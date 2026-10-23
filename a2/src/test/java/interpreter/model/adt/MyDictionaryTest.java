package interpreter.model.adt;

import interpreter.exceptions.ExpressionException;
import interpreter.model.value.IValue;
import interpreter.model.value.IntValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDictionaryTest {
    protected MyDictionary<String, IValue> dictionary;

    @BeforeEach
    void setUp() {
        this.dictionary = new MyDictionary<String, IValue>();
    }

    @AfterEach
    void tearDown() {
        this.dictionary = null;
    }

    @Test
    void lookup() throws ExpressionException {
        this.dictionary.put("a", new IntValue(3));

        assertNotEquals(new IntValue(4), this.dictionary.lookup("a"));
        assertThrows(ExpressionException.class, () -> this.dictionary.lookup("b"));
    }

    @Test
    void put() throws ExpressionException {
        this.dictionary.put("a", new IntValue(3));

        assertEquals(new IntValue(3), this.dictionary.lookup("a"));
    }

    @Test
    void update() throws ExpressionException {
        this.dictionary.put("a", new IntValue(3));
        this.dictionary.update("a", new IntValue(4));

        assertEquals(new IntValue(4), this.dictionary.lookup("a"));
        assertThrows(ExpressionException.class, () -> this.dictionary.update("b", new IntValue(4)));

    }
}
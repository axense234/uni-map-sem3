package interpreter.model.adt;

import interpreter.model.value.IValue;
import interpreter.model.value.IntValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    protected MyList<IValue> list;

    @BeforeEach
    void setUp() {
        this.list = new MyList<>();
    }

    @AfterEach
    void tearDown() {
        this.list = null;
    }

    @Test
    void add() {
        this.list.add(new IntValue(3));
        this.list.add(new IntValue(4));
        this.list.add(new IntValue(5));

        assertEquals(new IntValue(3), this.list.get(0));
        assertEquals(new IntValue(4), this.list.get(1));
        assertEquals(new IntValue(5), this.list.get(2));

    }

    @Test
    void get() {
        this.list.add(new IntValue(3));
        this.list.add(new IntValue(4));
        this.list.add(new IntValue(5));

        assertEquals(new IntValue(3), this.list.get(0));
        assertEquals(new IntValue(4), this.list.get(1));
        assertEquals(new IntValue(5), this.list.get(2));
    }

    @Test
    void size() {
        this.list.add(new IntValue(3));
        this.list.add(new IntValue(4));
        this.list.add(new IntValue(5));

        assertEquals(3, this.list.size());
    }
}
package interpreter.model.adt;

import interpreter.exceptions.ADTException;
import interpreter.model.exp.ValueExp;
import interpreter.model.stmt.AssignStmt;
import interpreter.model.stmt.IStmt;
import interpreter.model.stmt.NopStmt;
import interpreter.model.stmt.VarDeclStmt;
import interpreter.model.type.IntType;
import interpreter.model.value.IntValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    protected MyStack<IStmt> stack;

    @BeforeEach
    void setUp() {
        this.stack = new MyStack<>();
    }

    @AfterEach
    void tearDown() {
        this.stack = null;
    }


    @Test
    void testLIFOStackOrder() throws ADTException {
        this.stack.push(new NopStmt()); // nothing
        this.stack.push(new VarDeclStmt("a", new IntType())); // int a
        this.stack.push(new AssignStmt("a", new ValueExp(new IntValue(3)))); // a = 3


        IStmt nothingStatement = this.stack.pop();
        IStmt varDeclStatement = this.stack.pop();
        IStmt assignStatement = this.stack.pop();

        assertInstanceOf(NopStmt.class, nothingStatement);
        assertInstanceOf(VarDeclStmt.class, varDeclStatement);
        assertInstanceOf(AssignStmt.class, assignStatement);

    }

}
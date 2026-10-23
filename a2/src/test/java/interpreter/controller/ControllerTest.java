package interpreter.controller;

import interpreter.exceptions.MyException;
import interpreter.exceptions.StatementException;
import interpreter.model.PrgState;
import interpreter.model.adt.*;
import interpreter.model.stmt.IStmt;
import interpreter.model.stmt.NopStmt;
import interpreter.model.value.IntValue;
import interpreter.repo.Repo;
import interpreter.view.Examples;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    private static PrgState run(IStmt program) throws MyException {
        PrgState state = new PrgState(new MyStack<>(), new MyDictionary<>(),
                new MyList<>(), program);
        new Controller(new Repo(state), false).allStep(); // display off
        return state;
    }


    @Test
    void testExecutionProgram1() throws MyException {
        PrgState newState = run(Examples.ex1);
        assertTrue(newState.getExeStack().isEmpty());
        assertEquals(new IntValue(2), newState.getOut().get(0));
    }

    @Test
    void testExecutionProgram2() throws MyException {
        PrgState newState = run(Examples.ex2);
        assertTrue(newState.getExeStack().isEmpty());
        assertEquals(new IntValue(18), newState.getOut().get(0));
    }

    @Test
    void testExecutionProgram3() throws MyException {
        PrgState newState = run(Examples.ex3);
        assertTrue(newState.getExeStack().isEmpty());
        assertEquals(new IntValue(2), newState.getOut().get(0));
    }

    @Test
    void testEmptyExecutionStackError() {
        PrgState state = new PrgState(new MyStack<>(), new MyDictionary<>(),
                new MyList<>(), new NopStmt());

        Controller controller = new Controller(new Repo(state), false);
        assertThrows(StatementException.class, () -> controller.oneStep(state));
    }
}

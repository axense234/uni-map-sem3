package interpreter.controller;

import interpreter.exceptions.MyException;
import interpreter.exceptions.StatementException;
import interpreter.model.PrgState;
import interpreter.model.adt.IStack;
import interpreter.model.stmt.IStmt;
import interpreter.repo.IRepo;

public class Controller {
    IRepo repo;
    boolean display = false;

    public Controller(IRepo givenRepo, boolean display){
        this.repo = givenRepo;
        this.display = display;
    }

    public PrgState oneStep(PrgState state) throws MyException {
        IStack<IStmt> stack = state.getExeStack();
        if(stack.isEmpty()){
            throw  new StatementException("program state is empty");
        }

        IStmt crtStmt = stack.pop();
        return crtStmt.execute(state);
    }

    public void allStep() throws MyException {
        PrgState givenRepoState = repo.getPrgState();
        // display
        while(!givenRepoState.getExeStack().isEmpty()){
            this.oneStep(givenRepoState);
            // display
        }
    }

}

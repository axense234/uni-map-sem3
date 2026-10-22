package interpreter.model.stmt;

import interpreter.exceptions.MyException;
import interpreter.exceptions.StatementException;
import interpreter.model.PrgState;
import interpreter.model.adt.IDictionary;
import interpreter.model.adt.IStack;
import interpreter.model.exp.IExp;
import interpreter.model.type.BoolType;
import interpreter.model.value.BoolValue;
import interpreter.model.value.IValue;

public record IfStmt(IExp cond, IStmt thenS, IStmt elseS) implements IStmt{
    @Override
    public PrgState execute(PrgState state) throws MyException {
        IDictionary<String, IValue> symTable = state.getSymTable();
        IStack<IStmt> exeStack = state.getExeStack();

        IValue condValue = cond.eval(symTable);
        if(!(condValue.getType() instanceof BoolType)){
            throw new StatementException("condition is not an boolean");
        }

        BoolValue condValueBoolean = (BoolValue) condValue;
        if(condValueBoolean.val()){
            exeStack.push(thenS);
        } else {
            exeStack.push(elseS);
        }

        return state;
    }
}

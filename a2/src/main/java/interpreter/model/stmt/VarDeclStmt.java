package interpreter.model.stmt;

import interpreter.exceptions.MyException;
import interpreter.exceptions.StatementException;
import interpreter.model.PrgState;
import interpreter.model.adt.IDictionary;
import interpreter.model.type.BoolType;
import interpreter.model.type.IType;
import interpreter.model.type.IntType;
import interpreter.model.value.IValue;

public record VarDeclStmt(String name, IType type) implements IStmt {
    @Override
    public PrgState execute(PrgState state) throws MyException {
        if(!(type instanceof IntType || type instanceof BoolType)){
            throw new StatementException("invalid variable declaration type, available types: int and boolean");
        }

        IDictionary<String, IValue> symTable = state.getSymTable();
        if(symTable.isDefined(name)){
            throw new StatementException("variable declared twice");
        }

        symTable.put(name, type.defaultValue());

        return state;
    }

    @Override public String toString() { return type + " " + name; }
}

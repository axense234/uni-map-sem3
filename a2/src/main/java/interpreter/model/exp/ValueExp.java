package interpreter.model.exp;

import interpreter.exceptions.ExpressionException;
import interpreter.exceptions.MyException;
import interpreter.model.adt.IDictionary;
import interpreter.model.value.BoolValue;
import interpreter.model.value.IValue;
import interpreter.model.value.IntValue;

public record ValueExp(IValue givenValue) implements IExp{
    @Override
    public IValue eval(IDictionary<String, IValue> symTable) throws MyException {
        if(givenValue instanceof IntValue || givenValue instanceof BoolValue){
            return givenValue;
        }

        throw new ExpressionException("invalid value, supported instances: IntValue, BoolValue");
    }
}

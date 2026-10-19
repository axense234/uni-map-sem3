package interpreter.model.value;

import interpreter.model.type.BoolType;

public record BoolValue(boolean val) implements IValue {
    @Override
    public BoolType getType() {
        return new BoolType();
    }

    @Override
    public String toString(){
        return Boolean.toString(val);
    }
}


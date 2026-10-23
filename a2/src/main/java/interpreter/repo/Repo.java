package interpreter.repo;

import interpreter.model.PrgState;
import interpreter.model.adt.MyList;

public class Repo implements IRepo {
    MyList<PrgState> prgStates;

    public Repo(PrgState state) {
        this.prgStates = new MyList<>();
        this.prgStates.add(state);
    }

    @Override
    public PrgState getPrgState() {
        return this.prgStates.get(0);
    }
}
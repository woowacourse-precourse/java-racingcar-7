package racingcar.model.simulator;

import java.util.ArrayList;
import java.util.List;

public class SimulationResult<T> {
    private final List<T> result;

    public SimulationResult(){
        this.result=new ArrayList<>();
    }
    public void add(T content){
        result.add(content);
    }

    public List<T> getResult(){
        return this.result;
    }
}

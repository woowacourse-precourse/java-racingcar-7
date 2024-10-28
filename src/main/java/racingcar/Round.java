package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Round {
    private Map<Car, Integer> results;

    public Round(){
        this.results = new HashMap<Car, Integer>();
    }

    public void addResult(Car car){
        this.results.put(car, car.getMoveCount());
    }

    private void setResults(Map<Car, Integer> results){
        this.results = results;
    }

    public Map<Car, Integer> getResults(){
        return this.results;
    }
}

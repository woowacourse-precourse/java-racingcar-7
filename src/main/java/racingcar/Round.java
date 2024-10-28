package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
    private List<Car> cars;
    private Map<Car, Integer> results;

    public Round(){
        this.results = new HashMap<Car, Integer>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addResult(Car car){
        this.cars.add(car);
        this.results.put(car, car.getMoveCount());
    }

    private void setResults(Map<Car, Integer> results){
        this.results = results;
    }

    public Map<Car, Integer> getResults(){
        return this.results;
    }

    public String printResult(){
        StringBuilder result = new StringBuilder();
        for(Car car : cars){
            result.append(car.getCarName())
                    .append(" : ")
                    .append(printMovingTextureFromMoveCount(results.get(car)))
                    .append("\n");
        }

        return result.toString();
    }

    private String printMovingTextureFromMoveCount(int moveCount){
        return "-".repeat(Math.max(0, moveCount));
    }
}

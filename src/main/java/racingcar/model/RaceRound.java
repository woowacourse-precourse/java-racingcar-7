package racingcar.model;

import java.util.List;

public class RaceRound {
    private final int rounds;
    private Cars thisRoundCarList;

    public RaceRound(int roundInput, Cars thisRoundCarList) {
        this.thisRoundCarList = thisRoundCarList;
        this.rounds = roundInput;
    }

    public int getRounds() {
        return this.rounds;
    }

    public Cars getThisRoundCars() {
        return thisRoundCarList;
    }

    public String toStringRoundResult() {
        List<Car> cars = thisRoundCarList.getCarList();
        StringBuilder result = new StringBuilder();
        for(Car car : cars){
            result.append(car.getName()).append(": ").append(car.getDistance().getDistanceValue()).append("\n");
        }
        return result.toString();
    }

    public void roundStart(Cars cars){
        for(Car car : cars.getCarList()) {
            car.moveIfTrue(car.getRandomValue());
        }
    }

    public void saveRoundResult(Cars cars){
        this.thisRoundCarList = cars;
    }
}

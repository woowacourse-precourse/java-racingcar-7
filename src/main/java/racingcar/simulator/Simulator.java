package racingcar.simulator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.car.Car;

public class Simulator {

    private final int numberOfAttempts;
    private final int numberOfCars;
    private final int[] racingBoard;
    private final Map<Integer, Car> carMap = new HashMap<>();

    public Simulator(int numberOfAttempts, List<String> namesOfCars) {
        this.numberOfAttempts = numberOfAttempts;
        this.numberOfCars = namesOfCars.size();
        this.racingBoard = new int[namesOfCars.size()];

        for (int carId = 0; carId < namesOfCars.size(); carId++) {
            Car car = new Car(carId, namesOfCars.get(carId));
            this.carMap.put(carId, car);
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private int moveForwardByCondition(Car car) {
        int randomNumber = this.getRandomNumber();

        if (randomNumber >= 4) {
            return ++this.racingBoard[car.getId()];
        }

        return this.racingBoard[car.getId()];
    }

    public void simulate() {
        for (int tryCount = 1; tryCount <= this.numberOfAttempts; tryCount++) {
            for (int carId = 0; carId < this.numberOfCars; carId++) {
                Car currentOrderOfCar = carMap.get(carId);
                moveForwardByCondition(currentOrderOfCar);
            }
        }
    }

}

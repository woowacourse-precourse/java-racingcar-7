package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.RandomNumber;

public class RacingCarGame {

    private final List<Car> racingCars = new ArrayList<>();

    private final List<String> winnerCars = new ArrayList<>();
    private final RandomNumber randomNumber;

    public RacingCarGame(List<String> carNames, RandomNumber randomNumber) {
        for (String carName : carNames) {
            racingCars.add(Car.create(carName));
        }
        this.randomNumber = randomNumber;
    }

    public void moveCars() {
        int racingCarsCount = racingCars.size();
        List<Integer> randomNumbers = randomNumber.createNumbers(racingCarsCount);

        for (int i = 0; i < racingCarsCount; i++) {
            moveCar(racingCars.get(i), randomNumbers.get(i));
        }
    }

    private void moveCar(Car car, Integer number) {
        if (number >= 4) {
            car.move();
        }
    }

    public Map<String, Integer> getMoveResult() {
        Map<String, Integer> result = new HashMap<>();
        for (Car racingCar : racingCars) {
            result.put(racingCar.getName(), racingCar.getMove());
        }
        return result;
    }

    public List<String> findMaxMoveCars() {
        int maxMove = -1;
        for (Car racingCar : racingCars) {
            maxMove = compareMaxMoveCars(racingCar, maxMove);
        }
        return winnerCars;
    }

    private int compareMaxMoveCars(Car racingCar, int maxMove) {
        int move = racingCar.getMove();
        if (move > maxMove) {
            maxMove = move;
            winnerCars.clear();
            winnerCars.add(racingCar.getName());
        } else if (move == maxMove) {
            winnerCars.add(racingCar.getName());
        }
        return maxMove;
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    public RacingGame(List<String> carNames, int maxRound) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.maxRound = maxRound;
    }

    public HashMap<String, Integer> getState() {
        HashMap<String, Integer> state = new HashMap<>();
        for (Car car : cars) {
            state.put(car.getName(), car.getPosition());
        }
        return state;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void play() {
        for (int i = 0; i < maxRound; i++) {
            processRound();
            OutputHandler.printRoundResult(getState());
        }
        OutputHandler.printFinalWinners(getWinners());
    }

    private void processRound() {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }

    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> cars = new ArrayList<>();
    private final int maxRound;
}

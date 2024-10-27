package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car.Cars;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private final int RANDOM_NUMBER_MIN_SIZE = 0;
    private final int RANDOM_NUMBER_MAX_SIZE = 9;
    private final int FORWARD_MOVE_LIMIT = 4;

    private final Cars cars;

    public Referee(Cars cars) {
        this.cars = cars;
    }

    public boolean isForwardAllowed() {
        int stateNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_SIZE, RANDOM_NUMBER_MAX_SIZE);
        return stateNumber >= FORWARD_MOVE_LIMIT;
    }

    public void playRound() {
        for (int i = 0; i < cars.getCarListSize(); i++) {
            if (isForwardAllowed()) {
                cars.getCar(i).moveForward();
            }
        }
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < cars.getCarListSize(); i++) {
            carNames.add(cars.getCarListValue(i));
        }
        return carNames;
    }

    public List<Integer> getCarPositions() {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < cars.getCarListSize(); i++) {
            positions.add(cars.getCar(i).getPosition());
        }
        return positions;
    }

    public List<String> getWinners() {
        int maxPosition = 0;
        for (int i = 0; i < cars.getCarListSize(); i++) {
            if (cars.getCar(i).getPosition() > maxPosition) {
                maxPosition = cars.getCar(i).getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.getCarListSize(); i++) {
            if (cars.getCar(i).getPosition() == maxPosition) {
                winners.add(cars.getCar(i).getCarName());
            }
        }
        return winners;
    }
}
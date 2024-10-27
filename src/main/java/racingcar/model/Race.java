package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Race {
    private RaceTurn turn;
    private ArrayList<Car> carList = new ArrayList<>();

    public Race(int turn) {
        this.turn = new RaceTurn(turn);
    }

    public boolean isAvailableRace() {
        return this.turn.getTurn() > 0;
    }

    public void join(Car car) {
        this.carList.add(car);
    }

    public HashMap<String, Integer> playOneTurn() {
        this.turn.minusOneTurn();

        HashMap<String, Integer> allCarsNameAndPosition = new HashMap<>();
        carList.stream()
                .map(Car::randomlyMoveForward)
                .forEach(map -> allCarsNameAndPosition.putAll(map));

        return allCarsNameAndPosition;
    }

    public String getWinner() {
        int highestPosition = getHighestPosition();

        return carList.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public int getHighestPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}

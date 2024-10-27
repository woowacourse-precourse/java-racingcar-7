package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Race {
    private RaceTurn turn;
    private ArrayList<Car> carList = new ArrayList<>();

    public Race(int turn) {
        this.turn = new RaceTurn(turn);
    }

    public void join(Car car) {
        this.carList.add(car);
    }

    public HashMap<String, Integer> playOneTurn() {
        HashMap<String, Integer> allCarsNameAndPosition = new HashMap<>();

        carList.stream()
                .map(Car::randomlyMoveForward)
                .forEach(map -> allCarsNameAndPosition.putAll(map));

        return allCarsNameAndPosition;
    }
}

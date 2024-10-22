package racingcar.domain;

import java.util.Arrays;
import java.util.LinkedList;

public class RacingCars {

    private final LinkedList<RacingCar> cars = new LinkedList<>();

    public RacingCars(String input) {
        //TODO : , 상수
        Arrays.stream(input.split(","))
                .map(RacingCar::new)
                .forEach(cars::add);
    }

    public LinkedList<RacingCar> getCars() {
        return cars;
    }

    public RacingCars ready() {
        //TODO : 2 상수
        if (cars.size() < 2) {
            throw new IllegalArgumentException("경주에 필요한 최소 자동차 대수는 2대입니다.");
        }

        return this;
    }
}

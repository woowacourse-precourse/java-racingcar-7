package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int numberOfTrials;

    public RacingGame(int numberOfTrials, String... names) {
        this.numberOfTrials = numberOfTrials;
        this.cars = Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public void trial() {
        cars.forEach(car -> {
            car.move(Randoms.pickNumberInRange(0, 9));
        });
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public void play() {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTrials; i++) {
            trial();
            System.out.println(this.toString());
        }
    }
}

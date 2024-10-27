package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars;
    private static final int FORWARD_THRESHOLD = 4;
    private final Random random;
    private boolean isFirstRound = true; // 첫 번째 라운드인지 확인하는 변수

    public Racing(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.random = new Random();
    }

    public void startRace(int moves) {
        for (int i = 0; i < moves; i++) {
            for (Car car : cars) {
                if (random.nextInt(10) >= FORWARD_THRESHOLD) {
                    car.move();
                }
            }
            displayRaceStatus();
        }
    }
}

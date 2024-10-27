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

    private void displayRaceStatus() {
        if (isFirstRound) {
            System.out.println("실행 결과");
            isFirstRound = false;
        }

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
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

    private static class Car {
        private final String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public void move() {
            position++;
        }
    }
}

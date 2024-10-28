package racingcar.domain;

import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;
    private final OutputView outputView;

    public RacingGame(List<Car> cars, int attempts, OutputView outputView) {
        this.cars = cars;
        this.attempts = attempts;
        this.outputView = outputView;
    }

    public void play() {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
            // 각 시도 후 자동차 위치 출력
            outputView.printRoundResult(cars);
        }
    }

    public List<String> getWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new java.util.ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }
}

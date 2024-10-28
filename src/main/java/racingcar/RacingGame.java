package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;
    private final MoveStrategy moveStrategy;

    public RacingGame(List<Car> cars, int rounds, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.rounds = rounds;
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        for (int i = 0; i < rounds; i++) {
            moveCars();
            ResultView.printCurrentResults(cars); // 각 라운드 결과 출력
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            boolean canMove = moveStrategy.canMove(); // 이동 여부 결정
            car.move(canMove); // 이동
        }
    }

    public List<Car> getWinners() {
        // 최종 우승자 계산
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}

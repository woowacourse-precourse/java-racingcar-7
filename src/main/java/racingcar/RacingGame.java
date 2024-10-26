package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingGame {
    void start() {
        List<String> carNames = getCarNames();
        int attemptCount = getAttemptCount();
        List<Car> cars = createCars(carNames);

        race(attemptCount, cars);

        printWinner(cars);
    }

    private List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return List.of(Console.readLine().split(","));
    }

    private int getAttemptCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void race(int tryCount, List<Car> cars) {
        System.out.println("\n실행 결과");
        while (tryCount-- > 0) {
            cars.forEach(Car::tryMove);
            printCarPositions(cars);
        }
    }

    private void printCarPositions(List<Car> cars) {
        cars.forEach(car ->
                System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()))
        );
        System.out.println();
    }

    private void printWinner(List<Car> cars) {
        int winnerPosition = getWinnerPosition(cars);
        List<String> winnerCarNames = cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .toList();
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerCarNames));
    }

    private int getWinnerPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class CarRaceView {
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return parseTryCount(input);
    }

    private int parseTryCount(String input) {
        try {
            int tryCount = Integer.parseInt(input);
            validateTryCount(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
        }
    }

    public void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            String carPosition = "-".repeat(car.getPosition());
            System.out.print(carName + " : " + carPosition + "\n");
        }
        System.out.println();
    }

    public void displayWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = getWinners(cars, maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> getWinners(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
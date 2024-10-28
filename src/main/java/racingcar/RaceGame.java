package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private List<Car> cars;

    public void play() throws IllegalArgumentException {
        cars = initializerCars();
        int tryCnt = readTryCount();

        System.out.println("\n" + "실행 결과");
        for (int i = 0; i < tryCnt; i++) {
            simulate(cars);
            System.out.println();
        }

        printWinner(getWinnerNames(cars));
    }

    private List<Car> initializerCars() {
        String[] carNames = readCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void simulate(List<Car> cars) {
        System.out.println("\n" + "실행 결과");
        for (Car car : cars) {
            car.move();
        }
        printRaceStatus();
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            String position = car.getCarName() + " : "
                    + "-".repeat(Math.max(0, car.getPosition()));
            System.out.println(position);
        }
    }

    private List<String> getWinnerNames(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getPosition).max().orElse(0);
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private String[] readCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    private int readTryCount() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void printWinner(List<String> winnerNames) {
        System.out.println("최종 우승자 : "
                + String.join(", ", winnerNames));
    }
}

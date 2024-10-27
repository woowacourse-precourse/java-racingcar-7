package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = inputCarNames();
        int tryCount = inputTryCount();

        gameStart(cars, tryCount);

        printWinner(cars);
    }

    private static List<Car> inputCarNames() {
        List<Car> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        System.out.println();
        return count;
    }

    private static void gameStart(List<Car> cars, int tryCount) {
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }

            printProgress(cars);
        }
    }

    private static void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printWinner(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);

        List<String> winners = findWinners(cars, maxLocation);

        String finalWinner = String.join(", ", winners);
        System.out.println("최종 우승자 : " + finalWinner);
    }

    private static List<String> findWinners(List<Car> cars, int maxLocation) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static int findMaxLocation(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get()
                .getLocation();
    }
}

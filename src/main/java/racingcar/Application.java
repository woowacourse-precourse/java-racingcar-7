package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

// 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
// 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
// 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

// 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
// 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
// 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

// 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
// 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
public class Application {

    public static void main(String[] args)  {
        try {
            List<Car> cars = inputCarNames();
            int attempts = inputAttempts();

            System.out.println("\n실행 결과");

            playGame(cars, attempts);
            List<String> winners = getWinners(cars);
            printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNamesArray = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNamesArray) {
            cars.add(new Car(name));
        }

        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        return cars;
    }

    private static int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int attempts;
        try {
            attempts = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }

        return attempts;
    }

    private static void playGame(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            playRound(cars);
            System.out.println();
        }
    }

    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getName() + " : " + car.getProgress());
        }
    }

    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

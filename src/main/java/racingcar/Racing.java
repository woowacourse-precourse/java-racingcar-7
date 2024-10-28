package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars;
    private int attempts;

    public void start() {
        String namesInput = getUserName();
        attempts = getUserAttempts();
        cars = splitCarsName(namesInput);
        playGame();
        printWinners();
    }

    private String getUserName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int getUserAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> splitCarsName(String namesInput) {
        String[] names = namesInput.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name.trim()));
        }
        return carList;
    }

    private void playGame() {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRoundResults();
        }
    }

    private void printRoundResults() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private void printWinners() {
        int winnerPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

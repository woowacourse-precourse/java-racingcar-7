package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CarRacingGame {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int attempts = validateAttempts(input);
        return attempts;
    }

    public static int validateAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1 이상의 정수여야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }

    public static boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= MOVE_THRESHOLD;
    }

    public static void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getPositionDisplay());
        }
        System.out.println();
    }

    public static List<Car> initializeCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static List<String> findWinners(List<Car> cars) {
        int maxPosition = 0;

        // 첫 번째 루프: 가장 먼 위치(maxPosition)를 찾음
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 두 번째 루프: maxPosition에 있는 자동차의 이름을 리스트에 추가
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
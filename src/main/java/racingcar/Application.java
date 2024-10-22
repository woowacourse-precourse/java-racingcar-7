package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> cars = initializeCars();
        int moveCount = getMoveCount();

        System.out.println("\n실행 결과");
        for (int i = 0; i < moveCount; i++) {
            moveCars(cars);
        }

        ArrayList<String> winners = getWinners(cars);
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public static Map<String, Integer> initializeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        Map<String, Integer> cars = new LinkedHashMap<>();
        for (String carName : carNames) {
            validateCarName(carName);
            cars.put(carName.trim(), 0);
        }
        validateCarsCount(cars);

        return cars;
    }

    public static int getMoveCount() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }
    }

    public static void moveCars(Map<String, Integer> cars) {
        for (String carName : cars.keySet()) {
            int position = cars.get(carName);
            if (isMoveSuccess()) {
                cars.put(carName, ++position);
            }
            printCarMoveStatus(carName, position);
        }
        System.out.println();
    }

    public static boolean isMoveSuccess() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public static void printCarMoveStatus(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static ArrayList<String> getWinners(Map<String, Integer> cars) {
        ArrayList<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (String carName : cars.keySet()) {
            int position = cars.get(carName);
            if (position > maxPosition) {
                maxPosition = position;
                winners.clear();
                winners.add(carName);
            } else if (position == maxPosition) {
                winners.add(carName);
            }
        }
        return winners;
    }

    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateCarsCount(Map<String, Integer> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 1대 이상 있어야합니다.");
        }
    }
}

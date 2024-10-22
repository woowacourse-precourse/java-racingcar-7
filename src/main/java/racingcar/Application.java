package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        Map<String, Integer> cars = new LinkedHashMap<>();
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.put(carName.trim(), 0);
        }
        if (cars.size() < 1) {
            throw new IllegalArgumentException("자동차는 1대 이상 있어야합니다.");
        }

        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            int moveCount = Integer.parseInt(Console.readLine());

            System.out.println("\n실행 결과");
            for (int i = 0; i < moveCount; i++) {
                moveCars(cars);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }

        ArrayList<String> winners = getWinners(cars);
        System.out.print("최종 우승자 : " + String.join(", ", winners));
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
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static List<String> getCarsFromInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return new ArrayList<>(List.of(Console.readLine().split(",")));
    }
    public static void validateAndInitializeCars(List<String> cars, Map<String, Integer> carMoves) {
        for (String car : cars) {
            if (car.length() > 5 || car.trim().isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            carMoves.put(car, 0);
        }
    }
    public static int getCountFromInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 숫자만 입력해주세요.");
        }
    }
    public static int moveCar(int random, int movements) {
        if (random >= 4) {
            movements += 1;
        }
        return movements;
    }
    public static void calculateMovement(List<String> cars, Map<String, Integer> carMoves) {
        for (String car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            int movements = carMoves.get(car);
            movements = moveCar(random, movements);
            carMoves.put(car, movements);
        }
    }
    public static void displayMovement(List<String> cars, Map<String, Integer> carMoves) {
        for (String car : cars) {
            int movements = carMoves.get(car);
            System.out.println(car + " : " + "-".repeat(movements));
        }
    }
    public static int findMaxMovement(int maxNum, Map<String, Integer> carMoves) {
        for (int movement : carMoves.values()) {
            if (movement > maxNum) {
                maxNum = movement;
            }
        }
        return maxNum;
    }
    public static List<String> findWinners(List<String> cars, Map<String, Integer> carMoves, int maxNum) {
        List<String> winners = new ArrayList<>();
        for (String car : cars) {
            if (carMoves.get(car) == maxNum) {
                winners.add(car);
            }
        }
        return winners;
    }
    public static void main(String[] args) {
        Map<String, Integer> carMoves = new HashMap<>();
        List<String> cars = getCarsFromInput();
        int count = getCountFromInput();

        validateAndInitializeCars(cars, carMoves);

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            calculateMovement(cars, carMoves);
            displayMovement(cars, carMoves);
            System.out.println();
        }

        int maxNum = Integer.MIN_VALUE;
        maxNum = findMaxMovement(maxNum, carMoves);
        List<String> winners = findWinners(cars, carMoves, maxNum);
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}

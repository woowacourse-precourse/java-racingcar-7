package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCar {

    Map<String, Integer> cars = new LinkedHashMap<>();

    public void run() {
        inputCarName();
        int tryTimes = inputTryTimes();
        tryMoving(tryTimes);
        printWinner();
    }

    private void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            cars.put(carName, 0);
        }
    }

    private int inputTryTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryTimes = Integer.parseInt(Console.readLine().trim());
            return tryTimes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void tryMoving(int tryTimes) {
        System.out.println("\n" + "실행 결과");
        for (int i = 0; i < tryTimes; i++) {
            for (String carName : cars.keySet()) {

                if (Randoms.pickNumberInRange(0, 9) >= 4)
                    cars.put(carName, cars.get(carName) + 1);

                System.out.println(carName + " : " + hyphen(cars.get(carName)));
            }
            System.out.println();
        }
    }

    private void printWinner() {
        StringBuilder winner = new StringBuilder();
        int highScore = Collections.max(cars.values());
        for (String carName : cars.keySet()) {
            if (cars.get(carName) == highScore) {
                if (winner.length() > 0) {
                    winner.append(", " + carName);
                } else
                    winner.append(carName);
            }
        }
        System.out.println("최종 우승자 : " + winner.toString());
    }

    private String hyphen(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}

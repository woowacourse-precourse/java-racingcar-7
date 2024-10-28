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
        checkValidCarName(carNames);
    }

    private int inputTryTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryTimes = Integer.parseInt(Console.readLine().trim());
            return tryTimes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수가 숫자가 아닙니다.");
        }
    }

    private void tryMoving(int tryTimes) {
        System.out.println("\n" + "실행 결과");
        for (int i = 0; i < tryTimes; i++) {
            for (String carName : cars.keySet()) {
                checkMoving(carName);
                System.out.println(carName + " : " + hyphen(cars.get(carName)));
            }
            System.out.println();
        }
    }

    private void printWinner() {
        StringBuilder winners = new StringBuilder();
        int highScore = findHighScore();
        for (String carName : cars.keySet()) {
            findWinner(highScore, winners, carName);
        }
        System.out.println("최종 우승자 : " + winners.toString());
    }

    private void checkValidCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            if (cars.containsKey(carName)) {
                throw new IllegalArgumentException("차 이름이 중복되었습니다.");
            }
            if (carName.trim().equals("")) {
                throw new IllegalArgumentException("차 이름이 입력되지 않았습니다.");
            }
            cars.put(carName.trim(), 0);
        }
    }

    private void checkMoving(String carName) {
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            cars.put(carName, cars.get(carName) + 1);
    }

    private String hyphen(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    private int findHighScore() {
        return Collections.max(cars.values());
    }

    private void findWinner(int highScore, StringBuilder winners, String carName) {
        if (cars.get(carName) == highScore) {
            if (isJoint(winners))
                winners.append(", " + carName);
            else
                winners.append(carName);
        }
    }

    private boolean isJoint(StringBuilder winners) {
        if (winners.length() > 0)
            return true;
        return false;
    }

}

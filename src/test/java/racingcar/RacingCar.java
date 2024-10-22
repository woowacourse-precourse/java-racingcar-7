package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RacingCar {
    private int[] carCount;
    private String[] carList;

    String[] separateCarNames(String inputString) {
        if (!inputString.contains(",")) {
            throw new IllegalArgumentException("구분자가 없습니다.");
        }

        carList = inputString.split(",");
        carCount = new int[carList.length];

        for (String car : carList) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
            }
        }
        return carList;
    }

    int validateNumberOfAttempts(String inputString) {
        if (!inputString.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("시도할 횟수가 양수가 아닙니다.");
        }
        return Integer.parseInt(inputString);
    }

    void race(int numberOfAttempts) {

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfAttempts; i++) {
            eachCarGoOrStop();
            printEachResult();
        }
    }

    private void printEachResult() {
        for (int j = 0; j < carCount.length; j++) {
            System.out.println(carList[j] + " : " + "-".repeat(carCount[j]));
        }
        System.out.println();
    }

    private void eachCarGoOrStop() {
        for (int i = 0; i < carCount.length; i++) {
            if (generateRandomNumber() >= 4) {
                carCount[i]++;
            }
        }
    }

    protected int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    int[] getCarCount() {
        return carCount;
    }

    String extractWinners() {
        int maxCount = 0;
        ArrayList<String> winners = new ArrayList<>();

        for (int i = 0; i < carCount.length; i++) {
            if (carCount[i] > maxCount) {
                maxCount = carCount[i];
            }
        }

        for (int i = 0; i < carCount.length; i++) {
            if (carCount[i] == maxCount) {
                winners.add(carList[i]);
            }
        }

        if (winners.size() > 1) {
            return String.join(",", winners);
        }
        return winners.get(0);
    }
}

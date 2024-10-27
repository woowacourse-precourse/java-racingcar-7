package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private List<String> carNames;
    private List<Integer> carPositions;

    public void start() {
        String carNamesInput = inputCarNames();
        int raceAttempts = inputRaceAttempts();
        validateCarNames(carNamesInput);
        validateRaceAttempts(raceAttempts);
        initializeCars(carNamesInput);

        for (int i = 0; i < raceAttempts; i++) {
            moveCars();
            printRaceResults();
        }

        printWinners();
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int inputRaceAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 숫자로 입력해야 합니다.");
        }
    }

    private void validateCarNames(String carNamesInput) {
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private void validateRaceAttempts(int raceAttempts) {
        if (raceAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void initializeCars(String carNamesInput) {
        carNames = Arrays.asList(carNamesInput.split(","));
        carPositions = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carPositions.add(0);
        }
    }

    private void moveCars() {
        for (int i = 0; i < carPositions.size(); i++) {
            if (isMovable()) {
                carPositions.set(i, carPositions.get(i) + 1);
            }
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private List<String> getWinners() {
        int maxPosition = carPositions.stream().max(Integer::compare).orElse(0);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions.get(i) == maxPosition) {
                winners.add(carNames.get(i));
            }
        }
        return winners;
    }

    private void printRaceResults() {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carPositions.get(i)));
        }
        System.out.println();
    }

    private void printWinners() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
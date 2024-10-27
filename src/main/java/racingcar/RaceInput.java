package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RaceInput {
    private String carNames;
    private int totalAttempts;

    public RaceInput() {
        this.carNames = getCarNamesInput();
        this.totalAttempts = getAttemptsInput();
    }

    private String getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        validateCarNamesInput(carNames);
        return carNames;
    }

    private int getAttemptsInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempts = Console.readLine();

        return validateAttemptsInput(inputAttempts);
    }

    private void validateCarNamesInput(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private int validateAttemptsInput(String inputAttempts) {
        if (inputAttempts == null || inputAttempts.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 비어있을 수 없습니다.");
        }

        int totalAttempts = Integer.parseInt(inputAttempts.trim());

        if (totalAttempts < 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 작을 수 없습니다.");
        }

        return totalAttempts;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }
}

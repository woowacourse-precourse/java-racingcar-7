package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateEmptyInput("경주할 자동차 이름", carNames);

        return carNames;
    }

    public String readTryRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();
        validateEmptyInput("시도할 횟수", tryCount);

        return tryCount;
    }

    private void validateEmptyInput(String inputName, String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s(을/를) 입력해야 합니다.", inputName));
        }
    }
}

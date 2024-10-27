package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateNotBlank(carNames);
        return carNames;
    }

    public String readTotalRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundNumber = Console.readLine();
        validateNotBlank(roundNumber);
        validatePositiveRoundNumber(roundNumber);
        return roundNumber;
    }

    public void validatePositiveRoundNumber(String input) {
        int roundNumber = Integer.parseInt(input);
        if (roundNumber < 1) {
            throw new IllegalArgumentException("총 라운드 수는 1 이상이어야 합니다.");
        }
    }

    public void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 빈 공백이거나 비어있으면 안 됩니다.");
        }
    }
}

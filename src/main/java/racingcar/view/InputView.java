package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String readTotalRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundNumber = Console.readLine();
        validatePositiveRoundNumber(roundNumber);
        return roundNumber;
    }

    public void validatePositiveRoundNumber(String number) {
        int roundNumber = Integer.parseInt(number);
        if (roundNumber < 1) {
            throw new IllegalArgumentException("총 라운드 수는 1 이상이어야 합니다.");
        }
    }
}

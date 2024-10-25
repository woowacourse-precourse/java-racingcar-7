package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public void startMessagePrint() {
        System.out.println(START_MESSAGE);
    }

    public void tryCountMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }
}

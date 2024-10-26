package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    public String readRawCarNames() {
        System.out.println("자동차 이름들을 입력해주세요(쉼표로 구분).");
        String userInput = readLine();
        return userInput;
    }

    public Integer readAttemptCount() {
        System.out.println("시도할 횟수를 입력해주세요");
        Integer attemptCount = Integer.parseInt(readLine());
        return attemptCount;
    }
}

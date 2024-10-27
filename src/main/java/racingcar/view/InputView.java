package racingcar.view;

import racingcar.model.Validation;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final Validation validation;

    public InputView(Validation validation) {
        this.validation = validation;
    }

    public String readRawCarNames() {
        System.out.println("자동차 이름들을 입력해주세요(쉼표로 구분).");
        String userInput = readLine();
        validation.validCarNameDelimiter(userInput);
        validation.checkEmptyInput(userInput);
        return userInput;
    }

    public Integer readAttemptCount() {
        System.out.println("시도할 횟수를 입력해주세요.");
        String attemptCount = readLine();
        validation.validateAttemptCount(attemptCount);

        return Integer.parseInt(attemptCount);
    }
}

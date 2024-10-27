package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputHandler {

    private final OutputHandler outputHandler;

    public InputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public UserInput inputCarNamesAndAttemptCount() {
        try {
            String carNamesInput = inputCarNames();
            String attemptCountInput = inputAttemptCount();

            return new UserInput(carNamesInput, attemptCountInput);
        } finally {
            Console.close();
        }
    }

    private String inputCarNames() {
        return getSafeInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String inputAttemptCount() {
        return getSafeInput("시도할 횟수는 몇 회인가요?");
    }

    // 빈 문자열도 입력 받기
    private String getSafeInput(String message) {
        outputHandler.outputMessageWithNewLine(message);
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
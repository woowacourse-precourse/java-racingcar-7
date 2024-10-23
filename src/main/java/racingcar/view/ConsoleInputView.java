package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {

    public String requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getValidatedUserInput();
    }

    public String getValidatedUserInput() {
        String userInput = Console.readLine();
        validateUserInputNotEmpty(userInput);
        return userInput;
    }

    private void validateUserInputNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력은 비어 있을 수 없습니다.");
        }
    }

}

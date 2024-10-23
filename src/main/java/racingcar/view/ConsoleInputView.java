package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {

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

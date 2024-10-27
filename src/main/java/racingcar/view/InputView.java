package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getUserInput();
    }

    public String requestNumberOfGames() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return getUserInput();
    }

    public String getUserInput() {
        String userInput = Console.readLine();
        InputValidator.validateUserInputNotEmpty(userInput);
        return userInput;
    }

}

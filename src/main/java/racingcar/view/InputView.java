package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarNames() {
        return getUserInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String getMoveCount() {
        return getUserInput("시도할 횟수는 몇 회인가요?");
    }

    private String getUserInput(String consoleMessage) {
        String userInput = "";
        while (userInput.isEmpty()) {  // 빈 문자열일 경우 다시 입력하도록 함
            System.out.println(consoleMessage);
            userInput = Console.readLine();
        }

        return userInput;
    }

}

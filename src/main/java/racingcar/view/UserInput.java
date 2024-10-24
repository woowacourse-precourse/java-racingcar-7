package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    public enum InputMessage{
        INPUT_CAR_NAME_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_TRY_NUM_PROMPT("시도할 횟수는 몇 회인가요?");

        final private String message;

        public String getMessage(){
            return message;
        }

        InputMessage(String message) {
            this.message = message;
        }
    }

    public String promptCarNameUserInput(){
        System.out.println(InputMessage.INPUT_CAR_NAME_PROMPT.getMessage());
        String inputMessage = readLine();
        return inputMessage;
    }
    public String promptTryNumUserInput(){
        System.out.println(InputMessage.INPUT_TRY_NUM_PROMPT.getMessage());
        String inputMessage = readLine();
        return inputMessage;
    }
}

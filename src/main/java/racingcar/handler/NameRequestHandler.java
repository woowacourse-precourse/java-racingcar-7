package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.message.ErrorMessage.BLANK_INPUT_ERROR;

public class NameRequestHandler {

    public String[] getNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawInput = Console.readLine();
        validateBlank(rawInput);
        return null;
    }

    public void validateBlank(String rawInput) {
        if(rawInput == null || rawInput.isBlank()){
            System.out.println(BLANK_INPUT_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }
}

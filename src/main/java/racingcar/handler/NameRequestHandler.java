package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.message.ErrorMessage.BLANK_INPUT_ERROR;

public class NameRequestHandler {

    public String[] getNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawInput = Console.readLine();
        ValidateBlank(rawInput);
        return null;
    }

    private void ValidateBlank(String rawInput) {
        if(rawInput.isBlank()){
            throw new IllegalArgumentException(BLANK_INPUT_ERROR.getMessage());
        }
    }
}

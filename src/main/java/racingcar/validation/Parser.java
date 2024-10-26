package racingcar.validation;

import static racingcar.view.ErrorMessage.INVALID_PLAY_TIMES;

public class Parser {
    public Parser(){
    }

    public int stringToInt(String input){
        if (!input.matches("^[0-9]*$") || input.equals("0")){
            throw new IllegalArgumentException(INVALID_PLAY_TIMES.format());
        }
        return Integer.parseInt(input);
    }
}

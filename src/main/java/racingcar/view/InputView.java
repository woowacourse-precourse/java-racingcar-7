package racingcar.view;

import static racingcar.message.SystemMessage.*;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public String readCars(){
        return readLine(REQUEST_CARS_NAME.getMessage());
    }

    public String readRound(){
        return readLine(REQUEST_ROUND_NUMBER.getMessage());
    }

    protected String readLine(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}

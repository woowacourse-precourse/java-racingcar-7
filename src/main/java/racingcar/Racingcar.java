package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racingcar {
    public void splitInputValue(String input_value) {
        String[] carNames = input_value.split(",");
        for (String carName : carNames) {
            ErrorValidator.carName(carName);
        }
    }

    public void start() {
        System.out.println(Contants.NOTICE_CAR_NAMES);
        String input_value = Console.readLine();
        splitInputValue(input_value);
    }
}

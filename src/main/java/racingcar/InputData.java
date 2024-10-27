package racingcar;

import static racingcar.ConstantMessage.GAME_START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputData {

    public static String getInputData() {
        System.out.println(GAME_START_MESSAGE);
        return Console.readLine();
    }
}

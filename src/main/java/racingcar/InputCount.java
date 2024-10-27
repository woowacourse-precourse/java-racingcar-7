package racingcar;

import static racingcar.ConstantMessage.COUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputCount {

    public static String getInputCountData() {
        System.out.println(COUNT_MESSAGE);
        return Console.readLine();
    }
}

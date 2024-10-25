package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputCarNames {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public List<String> inputNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String cars = Console.readLine();

        return parsingName(cars);
    }

    public List<String> parsingName(String cars) {

        return null;
    }
}

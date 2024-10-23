package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InputView {
    private final static String INPUT_CAR_NAMES="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String Car_names(){
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine();
    }
}

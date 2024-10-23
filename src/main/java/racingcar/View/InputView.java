package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InputView {
    private final static String INPUT_CAR_NAMES="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_GAME_COUNT="시도할 횟수는 몇 회인가요?";

    public static String Car_names(){
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine();
    }
    public static String Game_count(){
        System.out.println(INPUT_GAME_COUNT);
        return Console.readLine();
    }
}

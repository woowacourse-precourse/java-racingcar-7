package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES = "자동차 이름을 쉼표(,)로 구분해 입력하세요.";
    private static final String INPUT_COUNT = "시도할 횟수는 몇 회인가요?";

    public static String readCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public static String readCountOfRounds() {
        System.out.println(INPUT_COUNT);
        return Console.readLine();
    }
}
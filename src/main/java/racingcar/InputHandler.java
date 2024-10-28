package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static ArrayList<String> CarName = new ArrayList<String>();
    private static int racingCounter;

    public static void initInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarName.addAll(Arrays.asList(Console.readLine().split(",")));

        System.out.println("시도할 횟수는 몇 회인가요?");
        racingCounter = Integer.parseInt(Console.readLine());
    }

    public static ArrayList<String> getCarName() {
        return CarName;
    }

    public static int getRacingCounter() {
        return racingCounter;
    }
}

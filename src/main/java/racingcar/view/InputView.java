package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    static String START_LINE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static String TRY_LINE = "시도할 횟수는 몇 회인가요?";

    public static String[] getRacingCarsAndTryNumber() {
        System.out.println(START_LINE);
        String racingCars = readLine();
        System.out.println(TRY_LINE);
        String tryNumber = readLine();

        return new String[]{racingCars, tryNumber};
    }
}

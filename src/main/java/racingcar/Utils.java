package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class Utils {
    public static List<String> enterCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = Console.readLine();
        text = text.replaceAll(" ", "");
        return Arrays.asList(text.split(","));
    }
}

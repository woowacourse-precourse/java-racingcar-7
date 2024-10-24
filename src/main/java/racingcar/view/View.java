package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Parser;

public final class View {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<String> getCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        return Parser.parse(Console.readLine());
    }

    public static Integer getCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}

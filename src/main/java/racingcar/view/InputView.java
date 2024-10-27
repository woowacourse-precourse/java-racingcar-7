package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validation;

public class InputView {
    private static final String startMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryMessage = "시도할 횟수는 몇 회인가요?";

    public static String[] startView() {
        System.out.println(startMessage);
        String name = Console.readLine();
        String carNames[] = name.split(",");
        Validation.validateNames(carNames);
        return carNames;
    }

    public static int tryNum() {
        System.out.println(tryMessage);
        String input = Console.readLine();
        Validation.validateNum(input);
        return Integer.parseInt(input);
    }
}

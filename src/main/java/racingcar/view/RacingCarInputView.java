package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingCarInputView {

    public static List<String> inputCarNames() {
        List<String> carNames;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        carNames = Arrays.stream(input.split(",")).toList();

        return carNames;
    }
}

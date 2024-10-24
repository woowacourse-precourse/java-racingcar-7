package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {
        System.out.println("자동차 이름을 쉼표로 구분하여 입력하세요. (각 이름은 5자 이하)");
        String input = Console.readLine();
        List<String> list = Arrays.asList(input.split(","));
        return list;
    }

    public int getMoveCount() {
        System.out.println("경주 시도 횟수를 입력하세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}

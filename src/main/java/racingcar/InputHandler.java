package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputHandler {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = camp.nextstep.edu.missionutils.Console.readLine();
        return Arrays.asList(namesInput.split(","));
    }

    public static int getRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String countInput = camp.nextstep.edu.missionutils.Console.readLine();
        if (countInput.chars().allMatch( Character::isDigit ))
            return Integer.parseInt(countInput);
        else return 0;
    }

}

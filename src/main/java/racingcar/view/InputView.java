package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return List.of(carNames.split(","));
    }

    public static String getRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}

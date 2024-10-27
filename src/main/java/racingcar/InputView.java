package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> inputCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarName = Console.readLine();
        List<String> names = Arrays.asList(CarName.split(","));

        return names;
    }

    public int inputTryCount() {

        System.out.println(("시도할 횟수는 몇 회인가요?"));
        String cnt = Console.readLine();
        return Integer.parseInt(cnt);
    }
}

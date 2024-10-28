package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> inputCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarName = Console.readLine();
        List<String> names = Arrays.asList(CarName.split(","));

        validateCarNames(names);

        return names;
    }

    private void validateCarNames(List<String> names) {
        for (String name : names) {
            validateCarName(name);
        }
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 최대 5글자 입니다.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주세요.");
        }
    }

    public static int inputTryCount() {

        System.out.println(("시도할 횟수는 몇 회인가요?"));
        String cnt = Console.readLine();

        return Integer.parseInt(cnt);
    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public List<String> cars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return Validator.checkName(input);
    }

    public int counts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        return Validator.checkCount(input);
    }


}

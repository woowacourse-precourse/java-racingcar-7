package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;
import java.util.List;

public class InputView {
    public List<String> getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Validator.validateCarNames(Console.readLine());
    }

    public int getUserInputAsInt() {
        System.out.println("시도할 라운드 횟수는 몇 회인가요?");
        String input = Console.readLine();
        System.out.println();

        return Validator.validateRoundCount(input);
    }
}
package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.CountValidator;

public class InputView {

    public static String[] inputCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] names = Console.readLine().trim().split(",");
            CarNameValidator.checkValidNames(names);
            return names;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int inputCount() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String strCount = Console.readLine().trim();
            CountValidator.checkValidCount(strCount);
            return Integer.parseInt(strCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}

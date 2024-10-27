package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialCountValidator;

/**
 * InputView
 * - 사용자 입력 관리
 */
public class InputView {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine().trim();
        List<String> carNames = Arrays.asList(input.split(","));
        CarNameValidator.validateNames(carNames);

        return carNames;
    }

    public static int getTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String trialCountInput = Console.readLine();
        TrialCountValidator.validate(trialCountInput);

        return Integer.parseInt(trialCountInput);
    }
}

package racingcar.view;
import racingcar.util.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Validator.validateCarNames(input);
        return input;
    }

    public static int getTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        Validator.validateTrialCount(input);
        return Integer.parseInt(input);
    }
}

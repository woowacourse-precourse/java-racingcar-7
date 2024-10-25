package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();

        List<String> returnCarNames = inputValidator.processCarNames(inputCars);

        return returnCarNames;
    }

    public int getAttemptNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempt = Console.readLine();

        int attemptNum = inputValidator.processAttempt(inputAttempt);

        return attemptNum;
    }

}

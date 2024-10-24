package racingcar.view;

import static racingcar.util.InputValidator.validateNotBlank;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        validateNotBlank(input);
        validateSingleComma(input);

        return input;
    }

    public int inputPlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);

        validateNotBlank(input);
        validatePlayCount(inputNumber);

        return inputNumber;
    }

    private void validateSingleComma(String input) {
        if (input.equals(",")) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePlayCount(int input) {
        if (input < 1 || input > 1000000)
            throw new IllegalArgumentException();
    }
}

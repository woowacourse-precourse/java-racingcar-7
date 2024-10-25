package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String getNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        InputValidator.validateNameOfCars(input);

        return input;
    }

    public int getTotalRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        InputValidator.validateTotalRounds(input);

        return Integer.parseInt(input);
    }
}
package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView instance;

    private InputView() {
    }

    public static synchronized InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }

        return instance;
    }

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String userInput = Console.readLine();

        return userInput.split(",");
    }

    public int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String userInput = Console.readLine();
        if (!validateMoveCountString(userInput)) {
            throw new IllegalArgumentException("이동 횟수 입력이 올바르지 않습니다.");
        }

        return Integer.parseInt(userInput);
    }

    private boolean validateMoveCountString(final String userInput) {
        if (userInput.isBlank() || !userInput.matches("\\d+")) {
            return false;
        }
        return true;
    }
}

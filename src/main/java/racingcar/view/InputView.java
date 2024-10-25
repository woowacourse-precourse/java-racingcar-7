package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private  InputView() {}

    public static String readInput() {
        String input = Console.readLine().trim();

        if(input.isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다. 값을 입력하셔야합니다.");
        }

        return input;
    }
}

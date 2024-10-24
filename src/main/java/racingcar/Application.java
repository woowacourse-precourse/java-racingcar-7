package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }

        new RacingGame().run(input);
    }
}

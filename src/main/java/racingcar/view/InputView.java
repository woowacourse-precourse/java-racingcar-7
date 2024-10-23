package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String INPUT_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_GAME_MATCHES = "시도할 횟수는 몇 회인가요?";

    public static String setInputCar() {
        System.out.println(INPUT_CAR);
        return Console.readLine();
    }

    public static String setInputGameMatches() {
        System.out.println(INPUT_GAME_MATCHES);
        return Console.readLine();
    }
}

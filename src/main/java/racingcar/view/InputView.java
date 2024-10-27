package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;

public class InputView {
    public static int trynum;
    public static String[] result;

    public InputView() {
        result = getUserInput();
        trynum = getTryCount();
        new GameController().runGame();
    }
    
    private String[] getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    private int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}

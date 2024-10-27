package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameWrapper {

    private final GameService racingGameService = new GameService();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racingGameService.setCarsNames(Console.readLine());
    }

}

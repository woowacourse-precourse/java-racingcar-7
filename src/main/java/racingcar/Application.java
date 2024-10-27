package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Controller.RacingGameController;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String tmp = Console.readLine();
        List<String> carNames = Arrays.asList(tmp.split(","));

        System.out.println("시도할 횟수는 몇 회인가요?");
        tmp = Console.readLine();
        int attemptCount = Integer.parseInt(tmp);

        racingGameController.RacingGame(carNames, attemptCount);

    }
}

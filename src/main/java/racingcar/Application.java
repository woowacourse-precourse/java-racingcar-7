package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Controller.RacingGameController;
import racingcar.Entity.Car;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String tmp = Console.readLine();
        List<String> carNames = Arrays.asList(tmp.split(","));

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        tmp = Console.readLine();
        int attemptCount = Integer.parseInt(tmp);

        // 시도 횟수 유효성 검사
        if (attemptCount <= 0) {
            throw new IllegalArgumentException();
        }

        String winnerNames = racingGameController.RacingGame(carNames, attemptCount);

        System.out.println("최종 우승자 : " + winnerNames);
    }
}

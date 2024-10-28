package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.manager.RacingManager;

public class RacingCarLauncher {

    private final RacingManager racingManager;

    public RacingCarLauncher(RacingManager racingManager) {
        this.racingManager = racingManager;
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = Console.readLine();
        racingManager.registerCars(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();
        racingManager.race(count);

        racingManager.presentWinner();
    }


}

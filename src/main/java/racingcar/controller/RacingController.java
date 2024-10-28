package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RaceResult;
import racingcar.service.RacingService;

public class RacingController {
    private final RacingService racingService;

    public RacingController() {
        this.racingService = new RacingService();
    }

    public void startRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());

        RaceResult raceResult = racingService.runRace(carNames, attempts);
        System.out.println(raceResult);
    }
}


package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingService;


public class RacingcarController {
    public final RacingService racingService;

    public RacingcarController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void getUserInput() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesOfCars = Console.readLine();
        if (namesOfCars.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력하세요.");
        }
        racingService.separateCarNames(namesOfCars);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfRaces = Integer.parseInt(Console.readLine());
        racingService.race(numberOfRaces);
    }
}

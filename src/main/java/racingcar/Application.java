package racingcar;

import racingcar.Model.RaceResult;
import racingcar.Service.RacingRaceService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingRace racingRace = new RacingRace();
        RacingRaceService racingRaceService = new RacingRaceService();

//        racingRace.racingRace();
        racingRaceService.racingRace();
    }
}

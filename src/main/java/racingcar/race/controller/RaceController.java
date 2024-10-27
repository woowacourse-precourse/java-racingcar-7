package racingcar.race.controller;

import java.util.List;
import java.util.Map;
import racingcar.race.domain.RaceMessage;
import racingcar.race.service.RaceService;

public class RaceController {
    public int raceEnterRound() {
        RaceService raceService = new RaceService();
        return raceService.enterRaceNumber();
    }

    public void raceProgression(int round, Map<String, String> cars) {
        RaceService raceService = new RaceService();
        RaceMessage.outputMessage();

        int currentRound = 0;
        while (round != currentRound) {
            raceService.currentRoundProgress(cars);
            currentRound++;
        }
    }

    public void raceWinnerCheck(Map<String, String> cars) {
        RaceService raceService = new RaceService();
        List<String> winners = raceService.finalRoundWinnerCheck(cars);
        String win = "";
        for (String winner : winners) {
            win = String.join(", ", winner);
        }
        System.out.println("최종 우승자 : " + win);
    }
}

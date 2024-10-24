package racingcar.controller;

import java.util.List;
import racingcar.domain.CarDomain;
import racingcar.domain.RaceDomain;
import racingcar.service.RaceService;
import racingcar.service.impl.RaceServiceImpl;
import racingcar.view.OutputView;
import racingcar.view.impl.ConsoleOutputView;

public class RaceController {

    RaceService raceService = new RaceServiceImpl();
    OutputView outputView = new ConsoleOutputView();

    public RaceDomain getRaceRequest(List<CarDomain> cars, Integer lastRound) {
        return RaceDomain.create(cars, lastRound);
    }

    public void executeRaceRequest(RaceDomain race) {
        System.out.println(outputView.displayRoundResultString());
        race.getCars().stream()
                .limit(race.getLastRound())
                .forEach(round -> {
                    raceService.runRoundRace(race);
                    System.out.println(outputView.displayEachRoundStatus(race.getCars()));
                    race.incrementCurrentRound();
                });
    }

    public void getWinnerRequest(RaceDomain race) {
    }
}

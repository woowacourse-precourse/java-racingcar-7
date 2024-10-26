package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.domain.CarDomains;
import racingcar.domain.RaceDomain;
import racingcar.service.RaceService;
import racingcar.service.impl.RaceServiceImpl;
import racingcar.view.OutputView;
import racingcar.view.impl.ConsoleOutputView;

public class RaceController {

    RaceService raceService = new RaceServiceImpl();
    OutputView outputView = new ConsoleOutputView();

    public RaceDomain getRaceRequest(CarDomains cars, Integer lastRound) {
        return RaceDomain.create(cars, lastRound);
    }

    public void executeRaceRequest(RaceDomain race) {
        System.out.println(outputView.displayRoundResultString());
        IntStream.range(0, race.getLastRound()).forEach(round -> {
            raceService.runOneRound(race);
            System.out.println(outputView.displayEachRoundStatus(race.getCars()));
        });
    }

    public void getWinnerRequest(RaceDomain race) {
        CarDomains winners = raceService.getWinners(race);
        System.out.println(outputView.displayCarRaceWinner(winners));
    }
}

package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.domain.CarDomains;
import racingcar.domain.RaceDomain;
import racingcar.service.RaceService;
import racingcar.view.OutputView;

public class RaceController {
    private static RaceController INSTANCE;

    private final RaceService raceService;
    private final OutputView outputView;

    private RaceController(RaceService raceService, OutputView outputView) {
        this.raceService = raceService;
        this.outputView = outputView;
    }

    public static synchronized RaceController getInstance(RaceService raceService, OutputView outputView) {
        if (INSTANCE == null) {
            INSTANCE = new RaceController(raceService, outputView);
        }
        return INSTANCE;
    }

    public RaceDomain getRaceRequest(CarDomains cars, Integer lastRound) {
        return RaceDomain.create(cars, lastRound);
    }

    public void executeRaceRequest(RaceDomain race) {
        outputView.displayRoundResultString();
        IntStream.range(0, race.getLastRound()).forEach(round -> {
            raceService.runOneRound(race);
            outputView.displayEachRoundStatus(race.getCars());
        });
    }

    public void getWinnerRequest(RaceDomain race) {
        CarDomains winners = raceService.getWinners(race);
        outputView.displayCarRaceWinner(winners);
    }
}

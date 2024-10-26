package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService;
    private final OutputView outputView;

    public RaceController(final RaceService raceService, final OutputView outputView) {
        this.raceService = raceService;
        this.outputView = outputView;

    }

    public Race registerRace(final List<Car> carList, final int attemptCount) {
        return raceService.registerRace(carList, attemptCount);
    }

    public void playRound(final Race race) {
        raceService.playRound(race);
    }

    public List<Car> getWinnerCarList(final Race race) {
        List<Car> carList = race.getCarList();
        int maxDistance = getMaxDistance(race);

        return raceService.getCarListWithMaxDistance(carList, maxDistance);
    }

//    private void printRoundResult(final Race race) {
//        outputView.printEndLine();
//        outputView.printGameResultMessage();
//        race.getCarList().forEach(outputView::printRoundResult);
//        outputView.printEndLine();
//    }

    private int getMaxDistance(final Race race) {
        List<Integer> distanceList = race.getDistanceList();
        return raceService.getMaxDistance(distanceList);
    }
}

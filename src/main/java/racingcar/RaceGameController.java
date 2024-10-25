package racingcar;

import java.util.List;

public class RaceGameController {
    private final InputView inputView;
    private final RandomRaceController randomRaceController;
    private final RaceWinnerView raceWinnerView;

    public RaceGameController() {
        this.inputView = new InputView();
        this.randomRaceController = new RandomRaceController();
        this.raceWinnerView = new RaceWinnerView();
    }

    public void start() {
        InputDTO inputDTO = inputView.getInput();
        Long tryNum = inputDTO.tryNums();
        List<RacingCar> racingCars = inputDTO.to();
        List<RacingCar> participantCars = randomRaceController.start(racingCars, tryNum);
        String[] winners = RaceJudge.determineWinner(participantCars);
        raceWinnerView.announceWinner(winners);
    }
}

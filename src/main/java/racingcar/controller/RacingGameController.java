package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.CarInputConverter;
import racingcar.util.RoundInputConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void run() {

        OutputView.requestCarName();
        String[] carNames = InputView.getCarNames();
        List<Car> raceParticipants = CarInputConverter.setCarList(carNames);

        OutputView.requestRound();
        String inputRound = InputView.getRound();
        int round = RoundInputConverter.setIntRound(inputRound);

        OutputView.startRacePrint();

        Race race = new Race(raceParticipants, round);

        race.start();

        List<Car> winner = race.getWinner();
        OutputView.printWinners(winner);


    }

}

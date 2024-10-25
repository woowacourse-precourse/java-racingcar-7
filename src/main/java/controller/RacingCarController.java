package controller;

import java.util.List;
import model.RacingCar;
import model.RacingGame;
import model.RandomRacingGameService;
import parser.RacingCarParser;
import parser.RacingRoundParser;
import validator.Validator;
import view.RacingCarView;

public class RacingCarController {

    public void run() {
        RacingCarView racingCarView = new RacingCarView();
        String cars = racingCarView.readCars();
        String roundString = racingCarView.readRaceRound();
        racingCarView.closeInput();

        Validator validator = new Validator();
        RacingCarParser racingCarParser = new RacingCarParser(validator);
        List<String> carNameList = racingCarParser.parseRacingCar(cars);

        RacingRoundParser racingRoundParser = new RacingRoundParser(validator);
        int round = racingRoundParser.parseRacingRound(roundString.trim());

        RacingGame racingGame = new RacingGame(RacingCar.createRacingCars(carNameList), round,
                new RandomRacingGameService());
        racingGame.startRace();
    }
}

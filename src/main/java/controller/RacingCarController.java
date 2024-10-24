package controller;

import java.util.List;
import parser.RacingCarParser;
import validator.Validator;
import view.RacingCarView;

public class RacingCarController {

    public void run() {
        RacingCarView racingCarView = new RacingCarView();
        String cars = racingCarView.readCars();
        String round = racingCarView.readRaceRound();
        racingCarView.closeInput();

        Validator validator = new Validator();
        RacingCarParser racingCarParser = new RacingCarParser(validator);
        List<String> carNameList = racingCarParser.parseRacingCar(cars);
    }
}

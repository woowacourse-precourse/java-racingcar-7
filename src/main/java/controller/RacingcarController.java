package controller;

import static util.Extractor.parseInput;
import static util.Input.getInput;
import static util.Race.startRacingAllCars;

import dto.RacingParam;
import repository.CarRepository;
import util.Output;

public class RacingcarController {

    public void run() {
        RacingParam racingParam = parseInput(getInput());
        CarRepository.saveCarsAndRepeatCount(racingParam);
        startRacingAllCars();
        Output.printRacingResult();
        Output.printWinningCars();
    }
}

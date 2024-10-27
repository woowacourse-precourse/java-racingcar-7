package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.view.Input;
import racingcar.view.Output;

public class Controller {
    public void startGame() {
        Input input = new Input();
        String carNames = input.requestCarNames();
        String raceRounds = input.requestRaceRounds();

        Cars cars = new Cars();
        cars.createRoundStatus(carNames);

        Race race = new Race();
        race.createRounds(raceRounds);

        repeatRounds(race, cars);
        race.createWinners(cars);

        Output output = new Output();
        output.printRaceWinners(race);
    }

    public void repeatRounds(Race race, Cars cars) {
        int rounds = race.getRounds();
        Output output = new Output();

        for (int count = 0; count < rounds; count++) {
            cars.updateRoundStatus(cars);
            output.printRoundStatus(cars, count);
        }
    }
}
package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.movement.RandomMovement;
import racingcar.domain.race.RaceRecord;
import racingcar.domain.race.RaceRoundRecord;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private  InputView inputView;
    private  OutputView outputView;
    private  RandomMovement randomMovement;

    public GameController(InputView inputView, OutputView outputView, RandomMovement randomMovement) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomMovement = randomMovement;
    }

    public void play() {
        Cars cars = Cars.from(inputView.inputCarnames());
        int gameTokens = inputView.inputGameTokens();
        cars.playOneRound(randomMovement);
        RaceRoundRecord raceRoundRecord = RaceRoundRecord.from(cars);
        RaceRecord raceRecord = new RaceRecord(raceRoundRecord);
        for (int i=0; i<gameTokens-1; i++){
            cars.playOneRound(randomMovement);
            raceRecord.add(RaceRoundRecord.from(cars));
        }
        outputView.printRaceRoundResults(raceRecord);
        outputView.printWinners(cars.getWinners());
    }
}

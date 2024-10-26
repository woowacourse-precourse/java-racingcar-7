package racingcar.controller;

import java.util.ArrayList;
import racingcar.domain.Cars;
import racingcar.domain.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    public void run(){
        String rawCarNames = InputView.requestCarNames();
        ArrayList<String> carNames = Parser.parse(rawCarNames);
        Cars cars = new Cars(carNames);

        String rawNumberOfTrials = InputView.requestNumberOfTrials();
        int numberOfTrials = Integer.parseInt(rawNumberOfTrials);

        proceedRacing(cars, numberOfTrials);

    }

    public void proceedRacing(Cars cars , int numberOfTrials ) {
        OutputView.printProcessResult();

        for (int i = 0; i < numberOfTrials; i++) {
            cars.proceedOneRound();
            ArrayList<String> currentStates = cars.getCurrentStates();
            OutputView.printRoundResult(currentStates);
        }
    }

}

package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Rounds;
import racingcar.view.InputView;

public class RacingGame {

    InputView inputView = new InputView();

    public void doGame() {
        Cars cars = makeCars(inputView.askCarName());
        Rounds rounds = new Rounds(inputView.askNumberOfRounds());
    }

    public Cars makeCars(String initialInput) {
        List<String> carNames = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(initialInput, ",");
        while (st.hasMoreTokens()) {
            carNames.add(st.nextToken());
        }
        Cars cars = new Cars(carNames);
        return cars;
    }
}


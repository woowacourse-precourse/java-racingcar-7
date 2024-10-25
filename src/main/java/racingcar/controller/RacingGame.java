package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Car;
import racingcar.domain.Rounds;
import racingcar.view.InputView;

public class RacingGame {

    InputView inputView = new InputView();

    public void doGame(){
        List<Car> cars = makeCars(inputView.askCarName());
        Rounds rounds = new Rounds(inputView.askNumberOfRounds());
    }

    private List<Car> makeCars(String initialInput) {
        List<Car> cars = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(initialInput, ",");
        while (st.hasMoreTokens()) {
            cars.add(new Car(st.nextToken()));
        }
        return cars;
    }
}


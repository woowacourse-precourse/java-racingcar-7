package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
    this.inputView = new InputView();
    this.outputView = new OutputView();
    }

    public void run(){
        List<Car> carList = makeCarList(inputView.names());
    }

    List<Car> makeCarList(String names){
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names.split(",")));
        ArrayList<Car> carList = new ArrayList<>();

        for (String name : nameList){
            carList.add(new Car(name));
        }

        return carList;
    }

}

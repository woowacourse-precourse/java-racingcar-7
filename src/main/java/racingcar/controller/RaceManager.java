package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceManager {
    private final InputView inputView;
    private List<Car> cars;

    public RaceManager(InputView inputView) {
        this.inputView = inputView;
    }

    public void run(){
        init(inputView.getName());
    }

    private void init(String input) {
        cars = new ArrayList<>();
        List<String> nameList = Arrays.stream(input.split(",")).toList();
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }
}

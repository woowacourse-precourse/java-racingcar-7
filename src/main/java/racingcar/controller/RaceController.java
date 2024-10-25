package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RaceService;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final RaceService service;

    public RaceController(InputView inputView, RaceService service) {
        this.inputView = inputView;
        this.service = service;
    }

    public void run(){
        service.init(inputView.getName());
    }

}

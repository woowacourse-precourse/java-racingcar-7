package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService service;

    public RaceController(InputView inputView, OutputView outputView, RaceService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run(){
        service.init(inputView.getName());

        int count = inputView.getCount();

        outputView.start();
        for (int i = 0; i < count; i++) {
            service.race();
            outputView.displayRace(service.getCars());
        }


    }

}

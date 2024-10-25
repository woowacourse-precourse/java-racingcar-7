package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingController {

    private final RacingService racingService;
    private final RacingCarView racingCarView;

    public RacingController() {
        this.racingService = new RacingService();
        this.racingCarView = new RacingCarView();
    }

    public void init(){
        String[] carNames = racingCarView.readCarName();
        List<Car> cars = racingService.generateCars(carNames);
        int num = racingCarView.readNum();
        racingService.initGame(cars,num);
    }



}

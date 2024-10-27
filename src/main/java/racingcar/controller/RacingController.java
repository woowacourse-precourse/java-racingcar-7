package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.service.RacingService;
import racingcar.util.Validatior;
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
        Validatior.isInteger(num);
        racingService.initGame(cars, num);
    }

    public void play(){
        racingCarView.printStarting();
        RacingGame racingGame = racingService.getRacingGame();
        int num = racingGame.getNum();
        for (int i = 0; i < num; i++) {
            List<Car> cars = racingService.playOneGame();
            racingCarView.printEachGame(cars);
        }
        List<Car> carList = racingGame.getWinner();
        racingCarView.printWinners(carList);
    }



}

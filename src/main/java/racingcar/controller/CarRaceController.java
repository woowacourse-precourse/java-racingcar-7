package racingcar.controller;

import racingcar.dto.RaceDto;
import racingcar.dto.ViewDto;
import racingcar.service.CarService;
import racingcar.view.RacingGameView;

public class CarRaceController {

    private final RacingGameView view;
    private final CarService service;

    public CarRaceController() {
        this.view = new RacingGameView();
        this.service = new CarService();
    }

    public void process() {
        ViewDto viewDto = view.startGame();
        RaceDto raceDto = service.playGame(viewDto.getCarName(), viewDto.getCount());
        view.endGame(raceDto.getRaceRounds(), raceDto.getWinnerCarName());
    }

}

package racingcar.application.service;

import java.util.List;
import racingcar.RacingCar;
import racingcar.application.Converter;
import racingcar.application.Game;
import racingcar.application.RacingManager;
import racingcar.view.ApplicationView;

public class RacingCarGame implements Game {

    private final ApplicationView applicationView;
    private final RacingManager<RacingCar> racingManager;
    private final Converter<RacingCar> converter;

    public RacingCarGame(ApplicationView applicationView,
            RacingManager<RacingCar> racingManager, Converter<RacingCar> converter) {
        this.applicationView = applicationView;
        this.racingManager = racingManager;
        this.converter = converter;
    }

    @Override
    public void play() {
        inputRacingCar();
    }

    private void inputRacingCar() {
        String responseCars = applicationView.requestInputCars();
        List<RacingCar> racingCars = converter.toObjects(responseCars);
        racingManager.registerAll(racingCars);
    }
}

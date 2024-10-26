package racingcar.core.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.core.service.RacingService;
import racingcar.core.view.RacingView;
import racingcar.domain.RacingCar;
import racingcar.properties.RacingProperties;

import java.util.LinkedHashSet;
import java.util.List;

public class RacingController {

    private static RacingController instance;

    private final RacingView racingView;
    private final RacingService racingService;

    private RacingController() {
        this.racingView = new RacingView();
        this.racingService = new RacingService();
    }

    public static RacingController getInstance() {
        if (instance == null) {
            instance = new RacingController();
        }

        return instance;
    }

    public void run() {
        String cars = racingView.inputCars();
        String tryCount = racingView.inputTryCount();

        racingView.printExcuteResult();

        List<RacingCar> winners = racingService
                .properties(getProperties())
                .raceStartAndGetWinners(cars, tryCount);

        racingView.printFinalWinners(winners);
    }

    public RacingProperties getProperties() {
        return RacingProperties.builder()
                .carNameFilter(this::allowAllCarNameFilter)
                .carPositionPrinter(this::defalutCarPositionPrinter)
                .carMoveNumberPicker(this::randomCarMoveNumberPicker)
                .build();
    }

    private boolean allowAllCarNameFilter(RacingCar car) {
        return true;
    }

    private void defalutCarPositionPrinter(LinkedHashSet<RacingCar> cars) {
        racingView.printCarsPosition(cars);
    }

    private int randomCarMoveNumberPicker() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

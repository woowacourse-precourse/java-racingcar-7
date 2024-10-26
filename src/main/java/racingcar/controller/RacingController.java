package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.Racing;
import racingcar.strategy.ModeType;
import racingcar.util.CarNameSeparator;
import racingcar.util.CarsCreator;
import racingcar.util.RacingResultCalculator;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class RacingController {
    private Integer totalRacingRound;
    private Racing racing;

    public RacingController(String carNames) {
        this.racing = new Racing(createCar(carNames));
    }

    private List<Car> createCar(String carNames) {
        List<String> carNamesList = CarNameSeparator.splitCarNameWithSeparator(carNames);
        return CarsCreator.createCarNameToCar(carNamesList);
    }

    public void setCarMode(ModeType modeType) {
        racing.setRacingCarMode(modeType);
    }

    public void setTotalRacingRound(String totalRacingRound) {
        //검증 로직 적용
        this.totalRacingRound = Integer.parseInt(totalRacingRound);
    }

    public void startRacing() {
        for (int racingRound = 0; racingRound < totalRacingRound; racingRound++) {
            racing.tryMovingCars();
            OutputView.printMessageWithLine(PrintMessage.LINE_SPACE);
        }
    }

    public List<String> endRacing() {
        List<Car> racingRecord = racing.getRacingCars();
        Integer racingWinnerRecord = RacingResultCalculator.getCarRacingWinnerRecord(racingRecord);
        return RacingResultCalculator.getCarRacingWinner(racingRecord, racingWinnerRecord);
    }
}

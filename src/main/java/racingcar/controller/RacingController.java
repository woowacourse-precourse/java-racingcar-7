package racingcar.controller;

import java.util.List;
import racingcar.exception.TotalRacingRoundException;
import racingcar.service.Racing;
import racingcar.strategy.ModeType;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class RacingController {
    private Integer totalRacingRound;
    private Racing racing;

    public RacingController(String carNames) {
        this.totalRacingRound = 0;
        this.racing = new Racing(carNames);
    }

    public void setCarMode(ModeType modeType) {
        racing.setRacingCarMode(modeType);
    }

    public void setTotalRacingRound(String totalRacingRound) {
        this.totalRacingRound = validate(totalRacingRound);
    }

    private Integer validate(String totalRacingRound) {
        Integer racingRound = TotalRacingRoundException.changeRoundTypeException(totalRacingRound);
        TotalRacingRoundException.racingRoundNumberRangeException(racingRound);
        return racingRound;
    }

    public void startRacing() {
        for (int racingRound = 0; racingRound < totalRacingRound; racingRound++) {
            racing.tryMovingCars();
            OutputView.printMessageWithLine(PrintMessage.LINE_SPACE);
        }
    }

    public List<String> endRacing() {
        return racing.getRacingWinner();
    }
}

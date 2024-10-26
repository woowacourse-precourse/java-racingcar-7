package racingcar.controller;

import java.util.List;
import racingcar.service.Racing;
import racingcar.strategy.ModeType;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class RacingController {
    private Integer totalRacingRound;
    private Racing racing;

    public RacingController(String carNames) {
        this.racing = new Racing(carNames);
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
        return racing.getRacingWinner();
    }
}

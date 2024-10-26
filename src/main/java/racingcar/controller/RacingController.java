package racingcar.controller;

import java.util.List;
import racingcar.service.Racing;
import racingcar.strategy.ModeType;
import racingcar.validation.RacingRoundValidation;
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
        Integer racingRound = Integer.parseInt(totalRacingRound);
        if (RacingRoundValidation.validateRacingRoundNumberRange(racingRound)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이동 시도 횟수는 1이상 양수여야 합니다.");
        }
        this.totalRacingRound = racingRound;
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

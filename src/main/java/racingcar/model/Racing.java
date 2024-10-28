package racingcar.model;

import java.util.List;
import java.util.Map;
import racingcar.service.RacingRoundService;
import racingcar.service.WinnerService;
import racingcar.view.OutputView;

public class Racing {

    private Map<String, Integer> racingCars;
    private Integer racingTotalRound;

    public Racing(Map<String, Integer> racingCars, Integer racingTotalRound) {
        this.racingCars = racingCars;
        this.racingTotalRound = racingTotalRound;
    }

    public void race() {
        RacingRoundService racingRoundService = RacingRoundService.getRacingRoundServiceInstance();
        OutputView outputView = OutputView.getOutputViewInstance();
        outputView.printRaceStart();

        int count = 0;
        while (count < racingTotalRound) {
            racingRoundService.racingRound(racingCars);
            outputView.printRoundState(racingCars);
            count++;
        }

        WinnerService winnerService = WinnerService.getWinnerServiceInstance();
        List<String> winners = winnerService.judgeWinner(racingCars);
        outputView.printWinnerView(winners);

    }

}

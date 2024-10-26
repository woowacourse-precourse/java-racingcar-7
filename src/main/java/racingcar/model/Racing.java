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

        int count = 0;
        RacingRoundService racingRoundService = new RacingRoundService();
        OutputView outputView = new OutputView();

        while (count < racingTotalRound) {
            racingRoundService.racingRound(racingCars);
            outputView.printOutputView(racingCars);
            count++;
        }

        WinnerService winnerService = new WinnerService();
        List<String> winners = winnerService.judgeWinner(racingCars);
        outputView.printWinnerView(winners);

    }

    //예외 메시지 출력하도록 기능 더하기

}

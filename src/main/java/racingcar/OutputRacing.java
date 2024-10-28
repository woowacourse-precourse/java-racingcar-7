package racingcar;

import java.util.List;

public class OutputRacing {
    public void printFinalResults(RandomRaceOrNot raceResult) {
        String[] carList = raceResult.getCarList();
        List<StringBuilder> progressList = raceResult.getProgressList();

        String winners = OutputWinner.findWinners(carList, progressList);
        System.out.println("최종 우승자 : " + winners);
    }
}


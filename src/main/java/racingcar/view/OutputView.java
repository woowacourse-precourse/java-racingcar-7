package racingcar.view;

import java.util.List;
import racingcar.domain.RaceRound;

public class OutputView {
    private static final String NORMAL_OUTPUT = "실행 결과";
    private static final String WINNER_OUTPUT = "최종 우승자 : ";

    public void printGameStart() {
        System.out.println(NORMAL_OUTPUT);
    }

    public void printRaceResult(List<RaceRound> raceRounds) {
        raceRounds.forEach(raceRound -> {
            raceRound.getCarPositions().forEach((car, position) ->
                    System.out.printf("%s : %s%n", car, position)
            );
            System.out.println();
        });
    }

    public void printWinners(String winners) {
        System.out.println(WINNER_OUTPUT + winners);
    }

}

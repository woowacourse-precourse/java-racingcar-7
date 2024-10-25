package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class OutputRacingCarView {
    private static final String GAME_RESULT_OUTPUT = "실행 결과\n%s";
    private static final String GAME_WINNERS_OUTPUT = "최종 우승자 : %s";

    public void outputGameResult(String gameResult) {
        System.out.printf(GAME_RESULT_OUTPUT, gameResult);
    }

    public void outputGameWinners(List<RacingCar> winners) {
        String[] gameWinners = winners.stream()
                .map(winner -> winner.getName())
                .toArray(String[]::new);
        System.out.printf(GAME_WINNERS_OUTPUT, String.join(", ", gameWinners));
    }
}

package racingcar.view;

import racingcar.dto.RacingResult;

public class OutputView {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RACING_RESULT_MESSAGE = "\n실행 결과";

    public void printRacingResult(RacingResult racingResult) {
        System.out.println(RACING_RESULT_MESSAGE);
        System.out.print(racingResult.getRecord());
        System.out.print(WINNER_MESSAGE + racingResult.getWinner());
    }
}

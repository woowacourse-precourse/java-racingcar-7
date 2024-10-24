package racingcar.view;

import racingcar.model.dto.GameResult;

import static racingcar.common.constant.OutputViewConst.*;

public class OutputView {

    public void noticeResult() {
        System.out.println(RESULT_PROMPT);
    }

    public void printResult(GameResult gameResult) {
        gameResult.getRoundResult()
                .forEach(round -> {
                    round.getResultList()
                            .forEach(System.out::print);
                    System.out.println();
                });
        System.out.printf(
                String.format("%s : %s", WINNER_PROMPT, gameResult.getWinner())
        );
    }
}

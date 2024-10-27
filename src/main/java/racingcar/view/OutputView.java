package racingcar.view;

import racingcar.model.GameResults;
import racingcar.model.GameResult;

public class OutputView {

    public void showGameResults(GameResults gameResults) {
        System.out.println("실행 결과");
        for (GameResult gameResult : gameResults.getGameResults()) {
            System.out.println(gameResult);
            if (gameResult.isLastGameResult()) {
                System.out.println("최종 우승자 : " + gameResult.getFinalWinnerForDisplay());
            }
        }
    }

}
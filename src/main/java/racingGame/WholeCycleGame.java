package racingGame;

import java.util.List;
import java.util.Map;
import output.ScoreOutput;
import output.WinnerOutput;

public class WholeCycleGame {
    OneCycleGame oneCycleGame = new OneCycleGame();
    GameOfScore gameOfScore = new GameOfScore();
    ScoreOutput scoreOutput = new ScoreOutput();
    WinnerOutput winnerOutput = new WinnerOutput();


    public void gameStart(List<String> participateCarList, int numberOfGameCycle) {
        Map<String, String> initialScore = gameOfScore.initializeScore(participateCarList);

        scoreOutput.printNoticeOfExecution();

        Map<String, String> finalScore = proceedRacingGame(participateCarList, initialScore, numberOfGameCycle);
        List<String> finalWinnerList = gameOfScore.makeFinalWinnerList(finalScore);

        winnerOutput.printFinalWinners(finalWinnerList);
    }

    private Map<String, String> proceedRacingGame(List<String> participateCarList, Map<String, String> initialScore,
                                                  int numberOfGameCycle) {
        Map<String, String> currentScore = initialScore;

        for (int i = 0; i < numberOfGameCycle; i++) {
            List<String> oneGameMoveCarList = oneCycleGame.oneGameResult(participateCarList);
            currentScore = gameOfScore.addResultOfOneGameScore(oneGameMoveCarList, initialScore);

            scoreOutput.printCurrentScore(currentScore);
        }

        return currentScore;
    }
}

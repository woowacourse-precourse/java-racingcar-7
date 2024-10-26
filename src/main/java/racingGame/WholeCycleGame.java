package racingGame;

import java.util.List;
import java.util.Map;
import output.ScoreOutput;

public class WholeCycleGame {
    OneCycleGame oneCycleGame = new OneCycleGame();
    Score score = new Score();
    ScoreOutput scoreOutput = new ScoreOutput();


    public void gameStart(List<String> participateCarList, int numberOfgameCycle) {
        Map<String, String> initialScore = score.initializeScore(participateCarList);
        Map<String, String> finalScore;

        scoreOutput.printResultOfExecution();

        for (int i = 0; i < numberOfgameCycle; i++) {
            List<String> oneGameMoveCarList = oneCycleGame.oneGameResult(participateCarList);
            // initial이라는 말이 마음에 들지 않는다.
            initialScore = score.resultOfOneGameScore(oneGameMoveCarList, initialScore);

            scoreOutput.printCurrentScore(initialScore);
        }

        finalScore = initialScore;
    }
}

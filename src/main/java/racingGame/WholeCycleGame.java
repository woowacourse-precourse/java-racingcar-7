package racingGame;

import java.util.List;
import java.util.Map;
import output.ScoreOutput;
import output.WinnerOutput;

public class WholeCycleGame {
    OneCycleGame oneCycleGame = new OneCycleGame();
    Score score = new Score();
    ScoreOutput scoreOutput = new ScoreOutput();
    WinnerOutput winnerOutput = new WinnerOutput();


    public void gameStart(List<String> participateCarList, int numberOfgameCycle) {
        Map<String, String> initialScore = score.initializeScore(participateCarList);

        // 이름바꾸기: printNoticeOfExecution
        scoreOutput.printResultOfExecution();

        for (int i = 0; i < numberOfgameCycle; i++) {
            List<String> oneGameMoveCarList = oneCycleGame.oneGameResult(participateCarList);
            // initial이라는 말이 마음에 들지 않는다. -> current score로 고치기 addResultOfOneGame 으로 이름 고치기
            initialScore = score.resultOfOneGameScore(oneGameMoveCarList, initialScore);

            scoreOutput.printCurrentScore(initialScore);
        }

        // finalscore가 어떻게 초기점수 ;;;
        List<String> finalWinnerList = score.makeFinalWinnerList(initialScore);

        winnerOutput.printFinalWinners(finalWinnerList);
    }
}

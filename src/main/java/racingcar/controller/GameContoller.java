package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameContoller {

    private static final int INITIAL_SCORE=0;
    private final Map<String, Integer> playerScoreBoard;
    private final Integer totalTurn;
    private final InputView inputView=new InputView();
    private final OutputView outputView=new OutputView();

    public GameContoller() {
        playerScoreBoard = new LinkedHashMap<>();
        mapPlayerNamesFromInput();
        totalTurn=inputView.readTurnFromInput();
    }

    public void run() {
        for (int curTurn = 0; curTurn < totalTurn; curTurn++) {
            moveCarsByRandomVal();
            outputView.printCurResult(playerScoreBoard);
        }
        outputView.printFinalResult(playerScoreBoard);
    }
    private void mapPlayerNamesFromInput() {
        List<String> playerNames= inputView.readPlayerNameList();
        playerNames.forEach((playerName)->{
            playerScoreBoard.put(playerName,INITIAL_SCORE);
        });
    }

    private void moveCarsByRandomVal() {
        playerScoreBoard.forEach((player,score)->{
            int randomVal= Randoms.pickNumberInRange(0,9);
            if(randomVal>=4){
                playerScoreBoard.put(player, score + 1);
            }
        });
    }
}

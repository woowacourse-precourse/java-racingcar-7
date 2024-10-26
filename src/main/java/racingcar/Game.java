package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.io.InputView;

public class Game {
    //TODO:
    // 1. `시도할 횟수` 마다 아래를 반복
    //    2. 각 자동차에 대해 해당 로직을 적용한다
    //    3. `pickNumberInRange()`값이 4이상 인지 판단
    //        - 4이상이라면 1회 전진
    private final Map<String, Integer> playerScoreBoard;
    private final Integer totalTurn;

    public Game() {
        playerScoreBoard = new HashMap<>();
        mapPlayerNamesFromInput();
        totalTurn=getTurnFromInput();
    }

    private void mapPlayerNamesFromInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput=Console.readLine();
        //TODO: 추후 예외처리 필요
        List<String> splitted= List.of(userInput.split(","));
        for (String player:splitted){
            playerScoreBoard.put(player,0);
        }
    }


    public void run() {
        for (int curTurn = 0; curTurn < totalTurn; curTurn++) {
            moveCarsByRandomV();
            printCurResult();
        }
        printFinalResult();
    }
}

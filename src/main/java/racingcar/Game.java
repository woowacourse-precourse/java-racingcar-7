package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


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

    private Integer getTurnFromInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String userInput=Console.readLine();
        //TODO: 추후 예외처리 필요
        return Integer.parseInt(userInput);
    }


    public void run() {
        for (int curTurn = 0; curTurn < totalTurn; curTurn++) {
            moveCarsByRandomVal();
            printCurResult();
        }
        printFinalResult();
    }

    private void printFinalResult() {
        //TODO: 최종 결과
        //map 안의 value 체크
        //value가 제일 높은거 저장, 출력
        List<String> winners=new ArrayList<>();
        playerScoreBoard.forEach((player,score)->{
            int maxScore=0;
            //최고점 갱신
            if(score>maxScore){
                winners.clear();
                winners.add(player);
                maxScore=score;
            }
            //최고점 동일
            if(score==maxScore){
                winners.add(player);
            }
        });

        System.out.println("최종 우승자 : "+String.join(", ",winners));
    }

    private void printCurResult() {
        playerScoreBoard.forEach((player,score)->{
            System.out.println(player+" : "+"-".repeat(score));
        });
        System.out.println();
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

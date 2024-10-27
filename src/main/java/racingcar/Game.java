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
    //게임이 관심있어 하는것?

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
        //아무값 없음,공백
        if(userInput.isBlank()|| userInput.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다");
        }
        List<String> splitted= List.of(userInput.split(","));
        for (String player:splitted){
            //1. 5글자 이하 [o]
            if(player.length()>5){
                throw new IllegalArgumentException("5글자 이하만 가능합니다");
            }
            playerScoreBoard.put(player,0);
        }
        //2. 중복된 이름X
        if(playerScoreBoard.size()!= splitted.size()){
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
        if(splitted.isEmpty()){
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다");
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
        Set<String> winners=new HashSet<>();
//        playerScoreBoard.forEach((player,score)->{
//            int maxScore=0;
//            //최고점 동일
//            if(score==maxScore){
//                winners.add(player);
//            }
//            //최고점 갱신
//            if(score>maxScore){
//                winners.clear();
//                winners.add(player);
//                maxScore=score;
//            }
//        });
        int maxScore=0;
        for (Map.Entry<String,Integer> playerentry: playerScoreBoard.entrySet()) {
            String player = playerentry.getKey();
            int score = playerentry.getValue();

            if (score > maxScore) {
                winners.clear();
                winners.add(player);
                maxScore = score;
            } else if (score == maxScore) {
                winners.add(player);
            }
        }

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

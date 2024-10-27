package racingcar;

import gameManager.Display;
import gameManager.GameManager;
import gameManager.JudgeManager;
import gameManager.ScoreManager;

import java.util.*;


public class Racingcar {

    GameManager gm = new GameManager();
    Display display = new Display();
    ScoreManager sm = new ScoreManager();
    JudgeManager jm = new JudgeManager();

    public void start() {
        display.requestName();
    }

    //이름 설정, 초기값 설정
    public void setNames() {
        display.setNames();
        display.setGamerNameArr(display.getNames());
        gm.setCarNames(display.getGamerNameArr());
    }

    public void requestRound() {
        display.requestRound();
    }

    //횟수 설정
    public void setRound() {
        display.setRound();
    }

    public void resultMsg() {
        display.resultMsg();
    }

    //한번 점수 넣기...
    public void roundOne(Map<String, Integer> map) {
        for (String name : gm.getAllGamer()) {
            int number = sm.getRandomNumber();
            int score = sm.getScore(number);
            gm.addScore(name, score);
            //System.out.println("name:" + name + ",score:" + score);
        }
        display.outputScores(map);
    }

    //횟수만큼 map 돌면서 점수
    public void game(Map<String, Integer> map, int round) {
        for (int i = 1; i <= round; i++) {
            roundOne(map);
        }
    }

    public Set<String> gameProcess() {
        Map<String, Integer> scores = gm.getGamerScores();
        int round = display.getRound();
        game(scores, round);
        return jm.judge(scores);
    }

    //game을 진행하고 위너를 출력
    public void winnerMsg() {
        display.winnerMsg(gameProcess());
    }

}

package racingcar;

import gameManager.Display;
import gameManager.GameManager;
import gameManager.JudgeManager;
import gameManager.ScoreManager;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingcarTest {

    Racingcar r = new Racingcar();
    GameManager gm = new GameManager();
    Display display = new Display();
    JudgeManager jm = new JudgeManager();
    ScoreManager sm = new ScoreManager();


    @Test
    void racingcarGame() {
    }



    /*@Test
    void roundOne() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("aaa",0);
        map1.put("vv",0);
        map1.put("qq",0);

        for(String name, map1.keySet()){
            int number = sm.getRandomNumber();
            int score = sm.getScore(number);
            gm.addScore(name, score);
        }


    }*/

    @Test
    void addScore() {
    }

    //[x] 이름 설정 테스트
    @Test
    void setNames() {
        String names = "aaa,bbb,vvv";

        display.setGamerNameArr(names);
        gm.setCarNames(display.getGamerNameArr());
        assertThat(gm.getAllGamer()).contains("aaa");
        assertThat(gm.getAllGamer()).contains("bbb");
        assertThat(gm.getAllGamer()).contains("vvv");
    }

    //[x]
    @Test
    void setRound() {
        String round = "5";

        display.setRound(round);

        assertThat(display.getRound()).isEqualTo(5);
    }


}

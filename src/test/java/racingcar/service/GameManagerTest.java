package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.randomtutils.FixedRandomGenerator;
import racingcar.randomtutils.RandomGenerator;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    public void setUp(){
        RandomGenerator fixedRandomGenerator = new FixedRandomGenerator(5);
        gameManager = new GameManager(new String[]{"do", "rae", "mi"}, 3,fixedRandomGenerator);

    }

    @Test
    void gameResultTest() {
        while(!gameManager.isGameOver()){
            gameManager.playGame();
        }

        assertThat(gameManager.getWinners()).hasSize(3);

    }

    @Test
    void gameRoundTest(){
        gameManager.playGame();
        gameManager.playGame();
        gameManager.playGame();
        assertThat(gameManager.isGameOver()).isEqualTo(true);
    }


}
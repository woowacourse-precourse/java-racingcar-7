package racingcar.domain.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameRuleTest {

    GameRule gameRule;

    @BeforeEach
    void beforeEach() {
        gameRule = new WootecoRule();
    }

    @Test
    public void 무작위값이_4이상일_경우_자동차는_전진할_수_있다() {
        //given
        int moveThresholdValue = 4;

        //when
        boolean isCarMove = gameRule.moveCondition(moveThresholdValue);

        //then
        Assertions.assertTrue(isCarMove);
    }

    @Test
    public void 자동차의_위치가_최대_위치보다_크거나_같으면_우승조건을_만족한다() {
        //given
        int currentCarPosition = 1;
        int maxCarPosition = 0;

        //when
        boolean result = gameRule.winCondition(currentCarPosition, maxCarPosition);

        //then
        Assertions.assertTrue(result);
    }
}
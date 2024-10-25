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
}
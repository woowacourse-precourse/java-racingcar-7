package racingcar.ready;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.RacingGame;

class RacingGameCreateNameTest {
    public RacingGame racingGame;

    @BeforeEach
    public void init() {
        racingGame = new RacingGame();
    }

    @Test
    public void 이름입력테스트() throws Exception {
        //given
        String input = "pobi,woni";
        //when
        String[] names = racingGame.createNames(input);
        //then
        Assertions.assertThat(names[0]).isEqualTo("pobi");
        Assertions.assertThat(names[1]).isEqualTo("woni");
    }

    @Test
    public void 이름입력_5글자예외테스트() throws Exception {
        //given
        String input = "pobi,javaji";
        //when

        //then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    racingGame.createNames(input);
                }).withMessage("차의 이름은 5글자 이하여야 합니다");
    }
}
package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingInfo;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    private Racing racing;

    @Test
    @DisplayName("자동차이름과_시도횟수_정상입력")
    void 자동차이름과_시도횟수_정상입력() {
        // given
        RacingInfo validRacingInfo = new RacingInfo(
                "pobi,choon,jason",
                3
        );
        
        // when
        racing = new Racing(validRacingInfo);
        racing.start();
        
        // then
        String actualWinners = racing.getWinners();
        assertThat(actualWinners).isIn("pobi", "choon", "jason");
    }

    @Test
    @DisplayName("자동차이름이_공백인경우_예외발생")
    void 자동차이름이_공백인경우_예외발생() {
        // given
        RacingInfo carNameEmpty = new RacingInfo(
                "",
                3
        );

        // then
        assertThatThrownBy(() -> {
            // when
            racing = new Racing(carNameEmpty);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름에_공백이_포함된_경우_예외발생")
    void 자동차이름에_공백이_포함된_경우_예외발생() {
        // given
        RacingInfo carNameIncludeEmpty = new RacingInfo(
                "pobi, jason, alice",
                3
        );

        // then
        assertThatThrownBy(() -> {
            // when
            racing = new Racing(carNameIncludeEmpty);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름이_중복된_경우_예외발생")
    void 자동차이름이_중복된_경우_예외발생() {
        // given
        RacingInfo carNameDuple = new RacingInfo(
                "pobi,pobi,pobi",
                3
        );

        // then
        assertThatThrownBy(() -> {
            // when
            racing = new Racing(carNameDuple);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름이_5글자_초과인경우_예외발생")
    void 자동차이름이_5글자_초과인경우_예외발생() {
        // given
        RacingInfo carNameOverLength = new RacingInfo(
                "pobipobi,em,alice",
                3
        );

        // then
        assertThatThrownBy(() -> {
            // when
            racing = new Racing(carNameOverLength);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름에_한글_영어_숫자_외의_문자포함된_경우_예외발생")
    void 자동차이름에_한글_영어_숫자_외의_문자포함된_경우_예외발생() {
        // given
        RacingInfo invalidCarName = new RacingInfo(
                "_3_,a2s,ada",
                3
        );

        // then
        assertThatThrownBy(() -> {
            // when
            racing = new Racing(invalidCarName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수가_0인_경우_예외발생")
    void 시도횟수가_0인_경우_예외발생() {
        // then
        assertThatThrownBy(() -> {
            // given, when
            new RacingInfo(
                    "pobi,alice,jason",
                    0
            );
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
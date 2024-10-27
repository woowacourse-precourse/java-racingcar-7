package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RandomGenerator;

public class RacingTest {


    @Test
    @DisplayName("랜덤으로 숫자 추출이 정상적으로 작동합니다.")
    void 랜덤으로_숫자_추출이_정상적으로_작동합니다() {
        //given
        RandomGenerator randomGenerator = new RandomGenerator();

        //when
        int randomNumber = randomGenerator.generateRandomNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("랜덤값이 4 이상이면 자동차가 전진할 수 있다.")
    void 랜덤값이_4_이상이면_자동차가_전진할_수_있다() {
        // given
        int number = 4;
        RandomGenerator randomGenerator = new RandomGenerator();

        // when
        boolean canMove = randomGenerator.canMoveForward(number);

        // then
        assertThat(canMove).isTrue();
    }

    @Test
    @DisplayName("랜덤값이 4_미만이면_자동차가_전진할_수_없다.")
    void 랜덤값이_4_미만이면_자동차가_전진할_수_없다() {
        // given
        int number = 3;
        RandomGenerator randomGenerator = new RandomGenerator();

        // when
        boolean canMove = randomGenerator.canMoveForward(number);

        // then
        assertThat(canMove).isFalse();
    }

}

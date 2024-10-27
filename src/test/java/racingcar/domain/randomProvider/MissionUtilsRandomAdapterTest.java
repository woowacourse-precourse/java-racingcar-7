package racingcar.domain.randomProvider;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class MissionUtilsRandomAdapterTest {

    @RepeatedTest(100)
    void 랜덤으로_고른_숫자는_해당_범위_내이다() {
        //given
        RandomAdapter sut = new MissionUtilsRandomAdapter();

        //when
        int result = sut.pickNumberInRange(0, 9);

        //then
        Assertions.assertThat(result).isBetween(0, 9);
    }
}
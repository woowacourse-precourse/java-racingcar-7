package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarView;

class SingletonObjectProviderTest {

    @DisplayName("싱글톤 객체 동일성 확인")
    @Test
    void getSingletonObjectTrue() {
        //given
        RacingCarController singletonObject = SingletonObjectProvider.getSingletonObject(RacingCarController.class);

        //when
        RacingCarController object = SingletonObjectProvider.getSingletonObject(RacingCarController.class);

        //then
        assertThat(singletonObject).isEqualTo(object);
    }

    @DisplayName("싱글톤 객체 동일성X 확인")
    @Test
    void getSingletonObjectFalse() {
        //given
        RacingCarController singletonObject = SingletonObjectProvider.getSingletonObject(RacingCarController.class);

        //when
        RacingCarView object = SingletonObjectProvider.getSingletonObject(RacingCarView.class);

        //then
        assertThat(singletonObject).isNotEqualTo(object);
    }
}
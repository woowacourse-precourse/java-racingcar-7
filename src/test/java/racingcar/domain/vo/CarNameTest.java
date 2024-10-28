package racingcar.domain.vo;

import org.junit.jupiter.api.Test;
import racingcar.exception.BusinessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    void 차량_이름_생성_테스트() {
        // given & when
        final CarName carName = new CarName("pobi");

        // then
        assertThat(carName.name()).isEqualTo("pobi");
    }

    @Test
    void 차량_이름이_5자_이상인_경우_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new CarName("pobiisbabo");
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 차량_이름이_비어있는_경우_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new CarName("");
        }).isInstanceOf(BusinessException.class);
    }
}
package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.exception.BusinessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    void 차량들을_가지는_일급컬렉션_생성() {
        // given & when
        Cars cars = new Cars("pobi,kang,kim");

        // then
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 차량_컬렉션_생성시_빈문자열을_받으면_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new Cars("");
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 차량_컬렉션_생성시_한개_이상의_차량_이름이_빈문자열_이라면_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new Cars("pobi,kang, ");
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 차량_컬렉션_생성시_콤마만_받은경우_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new Cars(",");
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 차량_컬렉션_생성시_같은_이름을_받은경우_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new Cars("kim,kim,kang");
        }).isInstanceOf(BusinessException.class);
    }

//    @Test
//    void 차량_컬렉션_생성시_쉼표로만_이루어_진_경우_BusinessException() {
//        // given & when & then
//        assertThatThrownBy(() -> {
//            new Cars(",,,");
//        }).isInstanceOf(BusinessException.class);
//    }
}

package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameConverterTest {

    @DisplayName("유효한 자동차 이름 문자열을 리스트로 변환한다.")
    @Test
    void convertValidCarNames() {
        //given
        String carNames = "Tesla,Kia,BMW";
        //when
        List<CarName> result = CarNameConverter.convert(carNames);
        //then
        assertThat(result)
                .hasSize(3)
                .extracting(CarName::name)
                .containsExactly("Tesla", "Kia", "BMW");
    }

    @DisplayName("여분의 공백이 있는 자동차 이름 문자열을 올바르게 변환한다.")
    @Test
    void convertStringWithExtraSpaces() {
        //given
        String carNames = " 마티즈 , Honda,  Audi ";
        //when
        List<CarName> result = CarNameConverter.convert(carNames);
        //then
        assertThat(result)
                .hasSize(3)
                .extracting(CarName::name)
                .containsExactly("마티즈", "Honda", "Audi");
    }

    @DisplayName("문자열이 비어있으면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "\n", "\t"})
    void throwExceptionWhenConvertBlank(String carNames) {
        assertThatThrownBy(() -> CarNameConverter.convert(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 공백없이 최소 1자부터 가능합니다.");
    }
}
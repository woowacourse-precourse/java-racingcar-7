package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

class CarsFactoryTest {

    @Test
    void 중복된_이름을_입력했을때_예외_발생() {
        String carsInput = "지우,지우,포비";
        assertThatThrownBy(() -> CarsFactory.makeCarList(carsInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("각 차는 한번만 입력해야 합니다");
    }

    @Test
    void 특정_이름이_여섯글자_이상일때_예외_발생() {
        String carsInput = "포비,임지우임지우임";
        assertThatThrownBy(() -> CarsFactory.makeCarList(carsInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("차는 다섯글자 이하이어야 합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"지우, 포비", "지우, ", " 지우,포비"})
    void 이름에_공백이_존재하면_예외_발생(String carsInput) {
        assertThatThrownBy(() -> CarsFactory.makeCarList(carsInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("차 이름에 공백이 존재할 수 없습니다");

    }

    @ParameterizedTest
    @ValueSource(strings = {",", "지우,", ",,"})
    void 입력_시작과_끝에_쉼표가_존재하면_예외_발생(String carsInput) {
        assertThatThrownBy(() -> CarsFactory.makeCarList(carsInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("입력의 시작과 끝은 쉼표가 될 수 없습니다");
    }

    @ParameterizedTest
    @MethodSource("generateCars")
    void 올바르게_입력하면_객체를_반환한다(String input, List<Car> carList) {
        assertThat(CarsFactory.makeCarList(input)).usingRecursiveComparison().isEqualTo(carList);
    }

    static Stream<Arguments> generateCars() {
        return Stream.of(
                Arguments.arguments("지우,포비,제이", List.of(new Car("지우", ""),
                        new Car("포비", ""),
                        new Car("제이", "")
                ))
        );
    }
}
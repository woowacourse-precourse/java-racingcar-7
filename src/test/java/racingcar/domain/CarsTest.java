package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 중복된_차를_입력했을때_예외_발생(){
        String carsInput="지우,지우,임지우";
        assertThatThrownBy(()->new Cars(carsInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("각 차는 한번만 입력해야 합니다");
    }

    @Test
    void 특정_차가_여섯글자_이상일때_예외_발생(){
        String carsInput="지우,임지우임지우임";
        assertThatThrownBy(()->new Cars(carsInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("차는 다섯글자 이하이어야 합니다");
    }

    @ParameterizedTest
    @MethodSource("generateCars")
    void 올바르게_입력하면_객체를_반환한다(Cars actual,Cars expected){
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);

    }

    static Stream<Arguments> generateCars(){
        Cars actualCars=new Cars("임지우,이지우,박지우");
        return Stream.of(
                Arguments.arguments(new Cars("임지우,이지우,박지우"),actualCars),
                Arguments.arguments(new Cars("임지우    ,이지우  , 박지우   "),actualCars),
                Arguments.arguments(new Cars("임지우,임 -지:"),new Cars("임지우,임-지:"))
                );
    }
}
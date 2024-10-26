package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @MethodSource("findWinners")
    void 우숭자를_구한다(Cars cars,String result){

        assertThat(cars.findWinners()).isEqualTo(result);
    }

    static Stream<Arguments> findWinners(){

        return Stream.of(
                Arguments.arguments(new Cars(List.of(
                        new Car("포비","---"),
                        new Car("지우","---"),
                        new Car("제이","--")))
                        ,"포비, 지우"),

                Arguments.arguments(new Cars(List.of(
                        new Car("포비",""),
                        new Car("지우","")))
                        ,"포비, 지우"),

                Arguments.arguments(new Cars(List.of(
                        new Car("포비","")))
                        ,"포비")
        );
    }
}
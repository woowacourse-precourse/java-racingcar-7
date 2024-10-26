package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @MethodSource("findWinnerNames")
    void 우숭자를_구한다(Cars cars,String result){

        assertThat(cars.findWinnerNames()).isEqualTo(result);
    }

    static Stream<Arguments> findWinnerNames(){

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

    @ParameterizedTest
    @MethodSource("proveUnmodifiableList")
    @DisplayName("복사한 객체가 기존과 다른 객체임을 입증한다")
    void 불변리스트_검증(Car clonedCar,Car originCar){
        assertThat(clonedCar).isNotEqualTo(originCar);
    }

    private static Stream<Arguments> proveUnmodifiableList() {
        List<Car> originList = List.of(new Car("지우", ""), new Car("제이", ""));
        Cars cars = new Cars(originList);
        List<Car> clonedList = cars.getClonedCars();

        return Stream.of(
                Arguments.of(clonedList.get(0), originList.get(0)),
                Arguments.of(clonedList.get(1), originList.get(1))
        );
    }
}
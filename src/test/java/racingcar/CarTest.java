package racingcar;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

class CarTest {
    @Test
    @DisplayName("자동차가 전진했을때 위치가 1씩 증가하는지 테스트")
    void randomlyMove() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");

        //when
        car1.moveRandomly(true);
        car1.moveRandomly(true);
        car2.moveRandomly(false);
        int car1Position= car1.getPosition();
        int car2Position= car2.getPosition();

        //then
        Assertions.assertThat(car1Position).isEqualTo(2);
        Assertions.assertThat(car2Position).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("wrongNameProvider")
    @DisplayName("자동차 이름 입력시 잘못된 이름이 있는 경우 예외처리 테스트")
    void createCarsByNamesFailTest(String wrongNamesStrings) {
        Assertions.assertThatThrownBy(() -> Car.createByStrings(wrongNamesStrings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> wrongNameProvider() {
        return Stream.of(
                Arguments.of("pobi,over5wordNames"),
                Arguments.of("pobi, abc@#$"),
                Arguments.of("pobi,sb gk"),
                Arguments.of("pobi,   ,  d  d "));
    };
    @ParameterizedTest
    @MethodSource("rightNameProvider")
    @DisplayName("문자열로 이름 입력시 Car생성 테스트")
    void createCarsByNamesSuccessTest(String rightNames, List<Car> expected) {
        //given
        //when
        List<Car> cars = Car.createByStrings(rightNames);

        List<String> createNames = cars.stream()
                .map(Car::getName)
                .toList();

        List<String> expectedNames = expected.stream()
                .map(Car::getName)
                .toList();
        //then
        Assertions.assertThat(createNames).containsExactlyInAnyOrderElementsOf(expectedNames);

    }

    static Stream<Arguments> rightNameProvider() {
        return Stream.of(
                Arguments.of("pobi,dodo"
                        , List.of(new Car("pobi"), new Car("dodo"))),
                Arguments.of("pobi,dol44"
                        , List.of(new Car("pobi"), new Car("dol44"))),
                Arguments.of("pobi,ss_g,hoon"
                        , List.of(new Car("pobi"), new Car("ss_g"), new Car("hoon"))));
    }
}

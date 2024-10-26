package racingcar;

import static racingcar.utils.InputValidator.validateNullOrEmpty;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomGenerator;
import racingcar.domain.RandomNumberGenerator;

public class ValidationTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름_빈값_예외_테스트(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car ", " car"})
    void 자동차_이름_공백_포함_예외_테스트(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"racing", "supercar", "qwer123"})
    void 자동차_이름_5글자이상_예외_테스트(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("DuplicatedCarNamesArguments")
    void 자동차_이름_중복_예외_테스트(List<Car> carList, RandomGenerator randomGenerator) {
        Assertions.assertThatThrownBy(() -> new Cars(carList, randomGenerator)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> DuplicatedCarNamesArguments() {
        return Stream.of(
                Arguments.of(List.of(new Car("car"), new Car("car")), new RandomNumberGenerator())
        );
    }
}

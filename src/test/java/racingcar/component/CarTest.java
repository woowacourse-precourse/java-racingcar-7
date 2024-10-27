package racingcar.component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @BeforeEach
    void clearNameCount() {
        Car.clearNameCount();
    }

    @ParameterizedTest
    @ValueSource(strings = {"x", "we", "our", "pobi", "crong", "honux", "ABCDE", "aBCdE"})
    void 올바른_이름이_입력되면_자동차는_생성된다(String name) {
        Car car = new Car(name);
        assertThat(car.toString()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123", "po bi", "javaji", "pobi1", "sdf2", "ABCDEF", "ABC1"})
    void 잘못된_이름이_입력되면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e: a,b,c,d,e",
            "pobi,woni: pobi,woni",
    }, delimiter = ':')
    void 올바른_문자열이_입력되면_자동차_리스트가_생성된다(String namesString, String expectedString) {
        List<Car> cars = Car.makeListFrom(namesString);
        List<String> expected = List.of(expectedString.split(","));

        IntStream.range(0, cars.size())
                .forEach(i -> assertThat(cars.get(i).toString()).isEqualTo(expected.get(i)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,a,a,a: a,b,a1,a2,a3",
            "pobi,woni,pobi: pobi,woni,pobi1",
            "pobi,woni,pobi,woni: pobi,woni,pobi1,woni1",
            "a,a,a,a,a: a,a1,a2,a3,a4",
    }, delimiter = ':')
    void 문자열에_중복된_이름이_존재하면_입력된_순서대로_숫자가_붙는다(String namesString, String expectedString) {
        List<Car> cars = Car.makeListFrom(namesString);
        List<String> expected = List.of(expectedString.split(","));

        IntStream.range(0, cars.size())
                .forEach(i -> assertThat(cars.get(i).toString()).isEqualTo(expected.get(i)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d,e,f", ",", "a,b,c,d,", ",a,b,c,d", ",a,b,c,d,"})
    void 잘못된_문자열이_입력되면_예외가_발생한다(String namesString) {
        assertThatThrownBy(() -> Car.makeListFrom(namesString)).isInstanceOf(IllegalArgumentException.class);
    }
}
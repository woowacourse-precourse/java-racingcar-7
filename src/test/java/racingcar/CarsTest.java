package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.OngoingValue.GO;
import static racingcar.OngoingValue.STOP;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
@DisplayName("게임 참여 자동차들 게임 테스트")
class CarsTest {

    @Nested
    class 자동차_경주_게임_참여_자동차_수_테스트 {

        @ParameterizedTest
        @ValueSource(ints = {0, 1001})
        void 참여하는_자동차_수가_1대_미만_혹은_1000대_초과라면_예외(int participantsNumber) {
            // given
            List<Car> cars = generateCars(participantsNumber);

            // when & then
            assertThatThrownBy(() -> {
                new Cars(cars);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 1000})
        void 참여하는_자동차_수가_1대_이상_1000대_이하라면_정상_진행이_가능하다(int participantsNumber) {
            // given
            List<Car> cars = generateCars(participantsNumber);

            // when & then
            assertDoesNotThrow(() -> {
                new Cars(cars);
            });
        }
    }

    @Nested
    class 가장_앞서있는_자동차_조회_테스트 {

        @Test
        void 자동차들_중_가장_앞에있는_자동차들을_조회한다() {
            // given
            Car car1 = new Car("1");
            Car car2 = new Car("2");
            Car car3 = new Car("3");
            car1.ongoing(GO);
            car1.ongoing(GO);
            car3.ongoing(GO);
            car3.ongoing(GO);
            Cars cars = new Cars(List.of(car1, car2, car3));

            // when
            List<Car> leadingCars = cars.getLeadingCars();

            // then
            assertThat(leadingCars)
                    .extracting(Car::getName)
                    .contains("1", "3");
        }
    }

    @Nested
    class 자동차들_전진_테스트 {

        @Test
        void 자동차들을_전진시킨다() {
            // given
            Car car1 = new Car("1");
            Car car2 = new Car("2");
            Car car3 = new Car("3");
            Cars cars = new Cars(List.of(car1, car2, car3));
            OngoingValueGenerator onGoingValueGenerator = new MockOngoingValueGenerator(GO, STOP, GO);

            // when
            cars.ongoingAllCars(onGoingValueGenerator);

            // then
            assertThat(cars.getCars())
                    .extracting(Car::getPosition)
                    .contains(1, 0, 1);
        }
    }

    private List<Car> generateCars(int participantsNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < participantsNumber; i++) {
            cars.add(new Car(String.valueOf(i)));
        }
        return cars;
    }
}

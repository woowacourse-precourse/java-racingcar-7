package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
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

    private List<Car> generateCars(int participantsNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < participantsNumber; i++) {
            cars.add(new Car(String.valueOf(i)));
        }
        return cars;
    }
}

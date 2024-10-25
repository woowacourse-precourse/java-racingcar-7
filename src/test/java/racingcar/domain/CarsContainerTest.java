package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.util.MockRandomGenerator;
import racingcar.util.RandomGenerator;

class CarsContainerTest {

    private CarsContainer carsContainer;

    @BeforeEach
    void setUp() {
        carsContainer = new CarsContainer(
                List.of(
                        new Car("song"),
                        new Car("park"),
                        new Car("lee"),
                        new Car("kim")
                )
        );
    }

    @Test
    @DisplayName("getCars() 불변 테스트")
    void canNotChangeCar() {
        // given
        List<Car> originalCars = List.of(
                new Car("song"),
                new Car("park"),
                new Car("lee"),
                new Car("kim")
        );
        CarsContainer carsContainer = new CarsContainer(originalCars);

        //when
        List<Car> copyCars = carsContainer.getCars();

        //then
        assertAll(
                () -> assertThat(originalCars.get(0)).isNotEqualTo(copyCars.get(0)),
                () -> assertThat(originalCars.get(1)).isNotEqualTo(copyCars.get(1)),
                () -> assertThat(originalCars.get(2)).isNotEqualTo(copyCars.get(2)),
                () -> assertThat(originalCars.get(3)).isNotEqualTo(copyCars.get(3))
        );
    }

    @Nested
    @DisplayName("현재 라운드 결과 반환 테스트(song,park,lee,kim)")
    class whenGetCurrentRoundResult {

        @Test
        @DisplayName("song,park만 움직인 경우")
        void successfullyMoveSongPark() {
            //given
            RandomGenerator randomGenerator = new MockRandomGenerator(List.of(9, 9, 0, 0));
            List<String> expected = List.of(
                    "song : -\n",
                    "park : -\n",
                    "lee : \n",
                    "kim : \n"
            );

            //when
            carsContainer.moveAll(randomGenerator);
            List<String> actual = carsContainer.getCurrentRoundResult();

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("lee,kim만 움직인 경우")
        void successfullyMoveLeeKim() {
            //given
            RandomGenerator randomGenerator = new MockRandomGenerator(List.of(0, 0, 9, 9));
            List<String> expected = List.of(
                    "song : \n",
                    "park : \n",
                    "lee : -\n",
                    "kim : -\n"
            );

            //when
            carsContainer.moveAll(randomGenerator);
            List<String> actual = carsContainer.getCurrentRoundResult();

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }
}
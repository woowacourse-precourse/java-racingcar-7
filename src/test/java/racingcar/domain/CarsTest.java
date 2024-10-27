package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<CarName> carNames = List.of(new CarName("pobi"), new CarName("woni"), new CarName("jun"));
        cars = new Cars(carNames);
    }

    @Test
    void 자동차들을_생성한다() {
        // when
        List<Car> actual = cars.getCars();

        // then
        assertThat(actual).hasSize(3);
        assertThat(actual)
                .extracting(car -> car.getCarName().getCarName())
                .containsExactlyInAnyOrder("pobi", "woni", "jun");
    }

    @Test
    void 단일_우승자를_반환한다() {
        // given
        List<Car> carList = cars.getCars();
        carList.getFirst()
                .moveCar(4); // pobi 의 position 을 이동시킨다
        String expected = "pobi";

        // when
        String actual = cars.getWinner();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 여러_우승자를_반환한다() {
        // given
        String expected = "pobi, woni, jun";

        // when
        String actual = cars.getWinner();

        // then
        assertThat(actual).contains("pobi","woni", "jun");
        assertThat(actual).isEqualTo(expected); // 반환 형식 자체가 똑같은지 검증한다
    }
}

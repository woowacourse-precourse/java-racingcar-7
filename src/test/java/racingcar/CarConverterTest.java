package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarConverterTest {

    CarConverter carConverter = new CarConverter();

    @Test
    @DisplayName("List<String>을 List<Car>로 변환 성공 테스트")
    public void stringList_carList_convert_테스트() {
        // given
        List<String> carNames = List.of("a", "b", "c");

        // when
        List<Car> cars = carConverter.to(carNames);

        // then
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("a");
        assertThat(cars.get(1).getName()).isEqualTo("b");
        assertThat(cars.get(2).getName()).isEqualTo("c");
    }

}
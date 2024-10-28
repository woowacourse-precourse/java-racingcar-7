package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RoundResultDtoTest {
    @Test
    void RoundResultDto_정상_생성() {
        //given
        List<Car> carList = List.of(new Car("car1"), new Car("car2"));

        //when
        RoundResultDto roundResultDto = new RoundResultDto(carList);

        //then
        assertThat(roundResultDto.carList()).isEqualTo(carList);
    }
}
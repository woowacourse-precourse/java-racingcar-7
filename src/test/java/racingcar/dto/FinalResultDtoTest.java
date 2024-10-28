package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class FinalResultDtoTest {

    @Test
    void FinalResultDto_정상_생성() {
        //given
        List<RoundResultDto> roundResultDtoList = List.of(
                new RoundResultDto(List.of(new Car("car1"), new Car("car2"))));
        List<String> winnerList = List.of("car1");

        //when
        FinalResultDto finalResultDto = new FinalResultDto(roundResultDtoList, winnerList);

        //then
        assertThat(finalResultDto.roundResultList()).isEqualTo(roundResultDtoList);
        assertThat(finalResultDto.winnerList()).isEqualTo(winnerList);
    }
}
package racingcar.util.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarConverterTest {
    @Test
    @DisplayName("정상적인 입력 문자열을 구분자를 기준으로 자동차 리스트로 변환한다.")
    public void convertToList() {
        String input = "pobi,woni,jun";
        List<Car> result = CarConverter.convert(input);
        assertThat(result).hasSize(3);
    }

    @Test
    @DisplayName("구분자가 없을시 단일 리스트로 변환한다.")
    public void convertToSingleList() {
        String input = "pobi";
        List<Car> result = CarConverter.convert(input);
        assertThat(result).hasSize(1);
    }

}

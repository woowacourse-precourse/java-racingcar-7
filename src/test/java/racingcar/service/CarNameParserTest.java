package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarNameParserTest {

    @DisplayName("문자열에서 자동차 이름을 추출합니다")
    @ParameterizedTest
    @MethodSource("provideInputAndExpectedList")
    void 자동차_이름_추출(String input, List<String> expectedList){
         List<String> carNames = CarNameParser.parseCarName(input);
         Assertions.assertThat(carNames).containsExactlyElementsOf(expectedList);
    }

    static Stream<Arguments> provideInputAndExpectedList() {
        return Stream.of(
                Arguments.of("one,two,three", Arrays.asList("one", "two", "three")),
                Arguments.of("ian, delta, tom", Arrays.asList("ian", "delta", "tom")),
                Arguments.of("dave,kevin, scar", Arrays.asList("dave", "kevin", "scar"))
        );
    }

    @DisplayName("추출한 자동차 이름을 이용해 Cars객체를 생성합니다")
    @Test
    void Cars_생성(){
        //given
        List<String> input= Arrays.asList("one", "two", "three");
        //when
        Cars createdCars = CarNameParser.createCars(input);
        //then
        Assertions.assertThat(createdCars).isInstanceOf(Cars.class);
    }
}

package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.View.ViewConstants.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.View.ViewConstants.NAME_DELIMITER;
import static racingcar.model.RacingConstants.REQUIRED_MIN_PLAYERS;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Racers;

class RacersTest {
    private final CarRacingService carRacingService = new CarRacingService();
    private List<String> inputNames;

    @DisplayName("입력된 자동차 이름이 2개 미만이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {",", ",,,,,", "pobi", "ab.cd", "jo ko"})
    void throwExceptionIfPlayersNotEnough(String input) {
        inputNames = split(input);

        assertThatThrownBy(() -> carRacingService.registerRacers(inputNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(REQUIRED_MIN_PLAYERS));
    }

    @DisplayName("입력된 자동차 이름에 중복이 있으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun,pobi", "가,가,가,가", "a,b,a,d,a,e,f", "0,0"})
    void throwExceptionWhenDuplicateNameIsIn(String input) {
        inputNames = split(input);

        assertThatThrownBy(() -> carRacingService.registerRacers(inputNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(DUPLICATE_NAME_ERROR_MESSAGE);
    }

    @DisplayName("입력된 자동차 이름이 2개 이상이고, 중복이 없으면 Racers 인스턴스 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,jun", "pobi,jun,woni", "가,나", "가나다라마,바사아자차,카타파하", "kim1,kim2,kim3,kim4,kim5"})
    void createRacers(String input) {
        inputNames = split(input);

        assertThat(carRacingService.registerRacers(inputNames)).isExactlyInstanceOf(Racers.class);
    }

    private List<String> split(String input) {
        return Arrays.stream(input.split(NAME_DELIMITER)).toList();
    }

    @DisplayName("getWinnerNames() 메서드가 우승자들의 이름을 반환한다.")
    @Test
    void returnWinnerNames() {
        Racers racers = new Racers(List.of(
                new Car("pobi", Integer.MAX_VALUE), new Car("woni", 4), new Car("jun", Integer.MAX_VALUE)
        ));

        List<String> actual = racers.getWinnerNames();
        List<String> expected = List.of("pobi", "jun");

        assertThat(actual).isEqualTo(expected);
    }
}
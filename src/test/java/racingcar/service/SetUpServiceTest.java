package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.RaceStatus;

public class SetUpServiceTest {
    static final String NAME_LENGTH_MASSAGE = "자동차 이름은 1글자 이상 5글자 이하여야 합니다.";
    static final String NAME_HAVE_BLANK_MASSAGE = "자동차 이름에는 공백이 포함될 수 없습니다.";
    static final String TOO_MANY_CARS_MASSAGE = "경주에 참가한 자동차 수가 너무 많습니다.";
    static final String DUPLICATE_CAR_NAME_MASSAGE = "중복된 자동차 이름은 사용할 수 없습니다.";

    SetUpService setUpService = SetUpService.getInstance();
    RaceStatus raceStatus = RaceStatus.getInstance();

    @Test
    @DisplayName("setUpService: 정상 입력 처리")
    public void setUpRaceTest_normalInput() {
        String normalInput = "pobi,woni,jun";

        setUpService.setUpRace(normalInput);

        assertEquals(raceStatus.getCarNumber(), 3);
        assertEquals(raceStatus.getCarByIndex(0).getName(), "pobi");
        assertEquals(raceStatus.getCarByIndex(1).getName(), "woni");
        assertEquals(raceStatus.getCarByIndex(2).getName(), "jun");

    }

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("invalidNames")
    @DisplayName("setUpService: 유효하지 않은 입력 처리")
    void setUpRaceTest_errorInput(String input, String message, String exceptionMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> setUpService.setUpRace(input));
        assertThat(e.getMessage()).isEqualTo(exceptionMessage);
    }

    static Stream<Arguments> invalidNames() throws Throwable {
        return Stream.of(
                Arguments.of("pobi,cinador", "자동차 이름 5자 초과", NAME_LENGTH_MASSAGE),
                Arguments.of("pobi,,,", "자동차 이름 1자 미만 1", NAME_LENGTH_MASSAGE),
                Arguments.of(",pobi", "자동차 이름 1자 미만 2", NAME_LENGTH_MASSAGE),
                Arguments.of("pobi,", "자동차 이름 1자 미만 3", NAME_LENGTH_MASSAGE),
                Arguments.of("", "공백 입력", NAME_LENGTH_MASSAGE),
                Arguments.of("A,B,C,D,E,F,G,H,I,J,K,L,M,N", "10개보다 많은 자동차", TOO_MANY_CARS_MASSAGE),
                Arguments.of("pobi,woni,pobi", "자동차 이름 중복 처리", DUPLICATE_CAR_NAME_MASSAGE),
                Arguments.of("pobi, wobi", "자동차 이름 공백 포함 1", NAME_HAVE_BLANK_MASSAGE),
                Arguments.of("pobi,wo bi", "자동차 이름 공백 포함 2", NAME_HAVE_BLANK_MASSAGE)
        );
    }
}

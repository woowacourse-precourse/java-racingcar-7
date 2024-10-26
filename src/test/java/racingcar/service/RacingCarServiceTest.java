package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.SeparatorParser;
import racingcar.validator.InputValidator;

class RacingCarServiceTest {

    private SeparatorParser separatorParser = new SeparatorParser();
    private InputValidator inputValidator = new InputValidator();
    private RacingCarService racingCarService = new RacingCarService(separatorParser, inputValidator);

    @DisplayName("유효한 자동차 이름 값이 주어질 때 경주할 자동차 이름들이 초기 설정된다.")
    @Test
    void initRacingCarsWhenCarNameInputIsValidValue() throws Exception {
        // given
        String inputCarNames = "pobi,alis,bamin";
        Field carsField = RacingCarService.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        LinkedHashMap<String, Integer> cars = (LinkedHashMap<String, Integer>) carsField.get(racingCarService);

        // when
        racingCarService.initRacingCars(inputCarNames);

        // then
        assertAll(
                () -> assertThat(cars.containsKey("pobi")),
                () -> assertThat(cars.containsKey("alis")),
                () -> assertThat(cars.containsKey("bamin"))
        );
    }

    @DisplayName("자동차 이름이 공백일 때 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCarNameInputIsBlank() {
        // given
        String inputCarNames = "";

        // when  // then
        assertThrows(IllegalArgumentException.class,
                () -> racingCarService.initRacingCars(inputCarNames));
    }

    @DisplayName("자동차 이름이 NULL일 때 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCarNameInputIsNull() {
        // given
        String inputCarNames = null;

        // when  // then
        assertThrows(IllegalArgumentException.class,
                () -> racingCarService.initRacingCars(inputCarNames));
    }

    @DisplayName("시도할 횟수로 양수 문자가 주어질 때 시도할 횟수가 초기 설정된다.")
    @Test
    void initRacingAttemptWhenAttemptInputIsValidValue() throws Exception {
        // given
        String inputAttempt = "5";
        Field attemptField = RacingCarService.class.getDeclaredField("attempt");
        attemptField.setAccessible(true);

        // when
        racingCarService.initRacingAttempt(inputAttempt);
        int attempt = (int) attemptField.get(racingCarService);

        // then
        assertThat(attempt).isEqualTo(Integer.valueOf(inputAttempt));
    }

    @DisplayName("시도할 횟수로 양수가 아닌 다른 문자가 주어질 때 예외가 발생한다.")
    @Test
    void throwsExceptionWhenAttemptInputIsNotANumber() {
        // given
        String inputAttempt = "abc";

        // when     // then
        assertThrows(IllegalArgumentException.class,
                () -> racingCarService.initRacingAttempt(inputAttempt));
    }

    @DisplayName("시도할 횟수로 양수가 아닌 Null이 주어질 때 예외가 발생한다.")
    @Test
    void throwsExceptionWhenAttemptInputIsNull() {
        // given
        String inputAttempt = null;

        // when     // then
        assertThrows(IllegalArgumentException.class,
                () -> racingCarService.initRacingAttempt(inputAttempt));
    }

    @DisplayName("시도할 횟수로 음수가 주어질 때 예외가 발생한다.")
    @Test
    void throwsExceptionWhenAttemptInputIsNegative() {
        // given
        String inputAttempt = "-3";

        // when     // then
        assertThrows(IllegalArgumentException.class,
                () -> racingCarService.initRacingAttempt(inputAttempt));
    }

    @DisplayName("우승자가 1명일 때 메시지가 정확히 생성된다.")
    @Test
    void generateWinnersMessageReturnsSingleWinnerMessage() throws Exception {
        // given
        Field carsField = RacingCarService.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        LinkedHashMap<String, Integer> cars = (LinkedHashMap<String, Integer>) carsField.get(racingCarService);
        cars.put("pobi", 5);
        cars.put("alis", 4);
        cars.put("bamin", 3);

        // when
        String resultMessage = racingCarService.getWinnersMessage();

        // then
        assertThat(resultMessage).isEqualTo("최종 우승자 : pobi");
    }

    @DisplayName("우승자가 여러 명일 때 메시지가 정확히 생성된다.")
    @Test
    void generateWinnersMessageReturnsMultipleWinnerMessage() throws Exception {
        // given
        Field carsField = RacingCarService.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        LinkedHashMap<String, Integer> cars = (LinkedHashMap<String, Integer>) carsField.get(racingCarService);
        cars.put("pobi", 5);
        cars.put("alis", 5);
        cars.put("bamin", 3);
        cars.put("jim", 5);

        // when
        String resultMessage = racingCarService.getWinnersMessage();

        // then
        assertThat(resultMessage).isEqualTo("최종 우승자 : pobi, alis, jim");
    }

    @DisplayName("한명도 전진하지 못했을 때 모두가 공동 우승자로 메시지가 정확히 생성된다")
    @Test
    void generateWinnersMessageWhenAllCarFailToMoveForward() throws Exception {
        // given
        Field carsField = RacingCarService.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        LinkedHashMap<String, Integer> cars = (LinkedHashMap<String, Integer>) carsField.get(racingCarService);
        cars.put("pobi", 0);
        cars.put("alis", 0);
        cars.put("bamin", 0);
        cars.put("jim", 0);

        // when
        String resultMessage = racingCarService.getWinnersMessage();

        // then
        assertThat(resultMessage).isEqualTo("최종 우승자 : pobi, alis, bamin, jim");
    }

    @DisplayName("지정된 시도 횟수만큼 레이싱 진행되어 랜덤 값에 따라 각 자동차가 전진하거나 정지한다.")
    @Test
    void displayRacingResultsCorrectlyForEachAttempt() throws Exception {
        // given
        String inputAttempt = "5";

        Field carsField = RacingCarService.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        LinkedHashMap<String, Integer> cars = (LinkedHashMap<String, Integer>) carsField.get(racingCarService);
        cars.put("pobi", 0);
        cars.put("alis", 0);
        cars.put("bamin", 0);
        cars.put("jim", 0);

        // when
        racingCarService.initRacingAttempt(inputAttempt);
        racingCarService.racing();

        // then
        boolean isValueChanged = cars.values().stream().anyMatch(value -> value > 0);
        assertThat(isValueChanged).isTrue();
    }
}
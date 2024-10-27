package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.enums.ExceptionMessage.ATTEMPTS_LESS_THAN_ONE;
import static racingcar.enums.ExceptionMessage.DUPLICATE_CAR_NAMES;
import static racingcar.enums.ExceptionMessage.EMPTY_CAR_NAME;
import static racingcar.enums.ExceptionMessage.EMPTY_CAR_NAMES;
import static racingcar.enums.ExceptionMessage.INVALID_ATTEMPTS_NUMBER;
import static racingcar.enums.ExceptionMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.enums.ExceptionMessage.SINGLE_CAR_NAME;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.CarRaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class CarRaceControllerTest {

    private CarRaceController carRaceController;

    @BeforeEach
    void setUp() {
        carRaceController = new CarRaceController(
                new CarRaceService(),
                new InputView(),
                new OutputView()
        );
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("공백은 입력할 수 없다.")
    void should_ThrowException_When_InputIsBlank() {
        //given
        System.setIn(getInputStream(" "));

        //expected
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carRaceController.run());
        assertEquals(EMPTY_CAR_NAMES.getMessage(), exception.getMessage());
    }

    private ByteArrayInputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("자동차 이름은 2개 이상 입력해야 한다.")
    void should_ThrowException_When_SingleCarNameIsProvided() {
        //given
        System.setIn(getInputStream("foo"));

        //expected
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carRaceController.run());
        assertEquals(SINGLE_CAR_NAME.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름은 중복될 수 없다.")
    void should_ThrowException_When_DuplicateCarNamesAreProvided() {
        //given
        System.setIn(getInputStream("foo,foo"));

        //expected
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carRaceController.run());
        assertEquals(DUPLICATE_CAR_NAMES.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 5자가 넘어갈 수 없다.")
    @ValueSource(strings = {"foobar,baz", "foo,bar,longName"})
    void should_ThrowException_When_CarNameExceedsMaxLength(String input) {
        //given
        System.setIn(getInputStream(input));

        //expected
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carRaceController.run());
        assertEquals(INVALID_CAR_NAME_LENGTH.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 공백이 될 수 없다.")
    @ValueSource(strings = {"foo,,bar", ",,foo", "foo,", "foo, ,bar"})
    void should_ThrowException_When_CarNameIsBlank(String input) {
        //given
        System.setIn(getInputStream(input));

        //expected
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carRaceController.run());
        assertEquals(EMPTY_CAR_NAME.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("시도 횟수는 1회 이상이어야 한다.")
    @ValueSource(strings = {"0", "-3"})
    void should_ThrowException_When_AttemptsAreLessThanOne(String input) {
        //given
        System.setIn(getInputStream("foo,bar\n" + input));

        //expected
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carRaceController.run());
        assertEquals(ATTEMPTS_LESS_THAN_ONE.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("시도 횟수는 양의 정수여야 한다.")
    @ValueSource(strings = {"abc", " ", "1.23"})
    void should_ThrowException_When_AttemptsAreNotPositiveInteger(String input) {
        //given
        System.setIn(getInputStream("foo,bar\n" + input));

        //expected
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carRaceController.run());
        assertEquals(INVALID_ATTEMPTS_NUMBER.getMessage(), exception.getMessage());
    }
}
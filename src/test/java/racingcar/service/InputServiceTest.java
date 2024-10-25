package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import error.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.InputService;

public class InputServiceTest {
    InputService inputService;

    @BeforeEach
    void setUp() {
        inputService = new InputService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"JOHN", "TONY", "POLY"})
    public void InputService_자동차이름_유효성테스트_통과(String newCarName) {
        assertThat(inputService.validateCarName(newCarName)).isEqualTo(newCarName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"JOHNYY", "TONYYY", "POLYYY"})
    public void InputService_자동차이름_유효성테스트_불통과_길이초과(String newCarName) {
        Assertions.assertThatThrownBy(() -> inputService.validateCarName(newCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_LENGTH_INVALID);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "      "})
    public void InputService_자동차이름_유효성테스트_불통과_공백(String newCarName) {
        Assertions.assertThatThrownBy(() -> inputService.validateCarName(newCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {" CARR ", "CARR ", "  CARR", "   CARRR   "})
    public void InputService_자동차이름_유효성테스트_통과_이름앞뒤_공백처리(String newCarName) {
        String expectedResult = newCarName.trim();
        assertThat(inputService.validateCarName(newCarName)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"carA", "carB", "carC"})
    public void InputService_자동차이름_유효성테스트_불통과_이미존재(String newCarName) {
        Assertions.assertThatThrownBy(() -> inputService.validateCarName(newCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_ALEADY_EXIST);
    }

    @Test
    public void InputService_자동차입력문_처리_테스트_통과() {
        String cars = "pobi,woni,jun";
        List<String> expectedCarNameList = new ArrayList<>();
        expectedCarNameList.add("pobi");
        expectedCarNameList.add("woni");
        expectedCarNameList.add("jun");

        List<String> actualCarNameList = inputService.extractValidCarNames(cars);
        assertThat(actualCarNameList).isEqualTo(expectedCarNameList);
    }


    @Test
    public void InputService_자동차입력문_처리_테스트_통과_이름앞뒤공백있을때() {
        String cars = "  pobi , woni , jun ";
        List<String> expectedCarNameList = new ArrayList<>();
        expectedCarNameList.add("pobi");
        expectedCarNameList.add("woni");
        expectedCarNameList.add("jun");

        List<String> actualCarNameList = inputService.extractValidCarNames(cars);
        assertThat(actualCarNameList).isEqualTo(expectedCarNameList);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pob,", "pob, ", "pob,jun,   "})
    public void InputService_자동차입력문_처리_테스트_불통과_쉼표로끝날떄(String cars) {
        assertThatThrownBy(() -> inputService.extractValidCarNames(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CARS_INPUT_END_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pob,,jun", " ,woni,jun", "pobi,  ,woni"})
    public void InputService_자동차입력문_처리_테스트_불통과_공백이름있을때(String cars) {
        assertThatThrownBy(() -> inputService.extractValidCarNames(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "car"})
    public void InputService_자동차입력문_처리_테스트_불통과_자동차하나일때(String cars) {
        assertThatThrownBy(() -> inputService.extractValidCarNames(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ONLY_ONE_CAR);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 5, 10})
    public void InputService_실행횟수_입력문_처리_테스트_통과(int count) {
        assertThat(inputService.validateCount(count)).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -5})
    public void InputService_실행횟수_입력문_처리_테스트_불통과_0이하(int count) {
        assertThatThrownBy(() -> inputService.validateCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.COUNTS_VALUE_INVALID);
    }
}

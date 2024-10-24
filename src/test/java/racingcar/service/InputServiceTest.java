package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import error.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.CarList;
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

    private List<String> extractCarNames(CarList carList) {
        List<String> carNames = new ArrayList<>();
        for (Car car : carList.getCars()) {
            carNames.add(car.getName());
        }
        return carNames;
    }


    @Test
    public void InputService_자동차입력문_처리_테스트_통과() {
        String cars = "pobi,woni,jun";
        List<String> expectedCarName = new ArrayList<>();
        expectedCarName.add("pobi");
        expectedCarName.add("woni");
        expectedCarName.add("jun");

        CarList actualCarList = inputService.extractValidCar(cars);
        List<String> actualCarName = extractCarNames(actualCarList);
        assertThat(actualCarName).isEqualTo(expectedCarName);
    }


    @Test
    public void InputService_자동차입력문_처리_테스트_통과_이름앞뒤공백있을때() {
        String cars = "  pobi , woni , jun ";
        List<String> expectedCarName = new ArrayList<>();
        expectedCarName.add("pobi");
        expectedCarName.add("woni");
        expectedCarName.add("jun");

        CarList actualCarList = inputService.extractValidCar(cars);
        List<String> actualCarName = extractCarNames(actualCarList);

        assertThat(actualCarName).isEqualTo(expectedCarName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pob,", "pob, ", "pob,jun,   "})
    public void InputService_자동차입력문_처리_테스트_불통과_쉼표로끝날떄(String cars) {
        assertThatThrownBy(() -> inputService.extractValidCar(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CARS_INPUT_END_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pob,,jun", " ,woni,jun", "pobi,  ,woni"})
    public void InputService_자동차입력문_처리_테스트_불통과_공백이름있을때(String cars) {
        assertThatThrownBy(() -> inputService.extractValidCar(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "car"})
    public void InputService_자동차입력문_처리_테스트_불통과_자동차하나일때(String cars) {
        assertThatThrownBy(() -> inputService.extractValidCar(cars))
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

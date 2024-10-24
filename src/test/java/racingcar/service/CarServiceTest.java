package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import error.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import model.CarList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.CarService;

public class CarServiceTest {
    static CarService carService;

    @BeforeAll
    static void setUpBeforeClass() {
        CarList carList = new CarList();
        carService = new CarService(carList);

        carList.addCar("carA");
        carList.addCar("carB");
        carList.addCar("carC");
    }

    @ParameterizedTest
    @ValueSource(strings = {"carD", "caca", "CAR!"})
    public void CarService_자동차존재유무_테스트_존재하지않을때(String newCarName) {
        assertThat(carService.isCarExist(newCarName)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"carA", "carB", "carC"})
    public void CarService_자동차존재유무_테스트_존재할때(String newCarName) {
        assertThat(carService.isCarExist(newCarName)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"JOHN", "TONY", "POLY"})
    public void CarService_자동차이름_유효성테스트_통과(String newCarName) {
        assertThat(carService.validateCarName(newCarName)).isEqualTo(newCarName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"JOHNYY", "TONYYY", "POLYYY"})
    public void CarService_자동차이름_유효성테스트_불통과_길이초과(String newCarName) {
        assertThatThrownBy(() -> carService.validateCarName(newCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_LENGTH_INVALID);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "      "})
    public void CarService_자동차이름_유효성테스트_불통과_공백(String newCarName) {
        assertThatThrownBy(() -> carService.validateCarName(newCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {" CARR ", "CARR ", "  CARR", "   CARRR   "})
    public void CarService_자동차이름_유효성테스트_통과_이름앞뒤_공백처리(String newCarName) {
        String expectedResult = newCarName.trim();
        assertThat(carService.validateCarName(newCarName)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"carA", "carB", "carC"})
    public void CarService_자동차이름_유효성테스트_불통과_이미존재(String newCarName) {
        assertThatThrownBy(() -> carService.validateCarName(newCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_ALEADY_EXIST);
    }

    @Test
    public void CarService_우승자뽑기_한명일때() {
        CarList carList = new CarList();
        CarService carService = new CarService(carList);

        carList.addCar("carA");
        carList.addCar("carB");
        carList.addCar("carC");
        carList.getCars().getFirst().addDistance();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("carA");

        assertThat(carService.getWinners()).isEqualTo(expectedResult);
    }

    @Test
    public void CarService_우승자뽑기_두명일때() {
        CarList carList = new CarList();
        CarService carService = new CarService(carList);

        carList.addCar("carA");
        carList.addCar("carB");
        carList.addCar("carC");
        carList.getCars().get(0).addDistance();
        carList.getCars().get(1).addDistance();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("carA");
        expectedResult.add("carB");

        assertThat(carService.getWinners()).isEqualTo(expectedResult);
    }

    @Test
    public void CarService_우승자뽑기_세명일때() {
        CarList carList = new CarList();
        CarService carService = new CarService(carList);

        carList.addCar("carA");
        carList.addCar("carB");
        carList.addCar("carC");
        carList.getCars().get(0).addDistance();
        carList.getCars().get(1).addDistance();
        carList.getCars().get(2).addDistance();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("carA");
        expectedResult.add("carB");
        expectedResult.add("carC");

        assertThat(carService.getWinners()).isEqualTo(expectedResult);
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import error.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import model.CarList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarListTest {
    CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarList();
    }

    @ParameterizedTest
    @ValueSource(strings = {"carA", "carB", "carC"})
    void CarList_자동차목록반환_테스트(String newCarName) {
        carList.addCar(newCarName);
        assertThat(carList.getCars()).hasSize(1);
    }

    @Test
    public void CarList_자동차목록세팅_테스트_통과() {
        List<String> carNames = new ArrayList<>();
        carNames.add("carA");
        carNames.add("carB");
        carNames.add("carC");

        carList.setCarList(carNames);
        assertThat(carList.getCars()).hasSize(3);
    }

    @Test
    public void CarList_자동차목록세팅_테스트_불통과_중복된차() {
        List<String> carNames = new ArrayList<>();
        carNames.add("carA");
        carNames.add("carB");
        carNames.add("carA");

        assertThatThrownBy(() -> carList.setCarList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_ALEADY_EXIST);
    }

    @ParameterizedTest
    @ValueSource(strings = {"carD", "caca", "CAR!"})
    public void CarList_자동차존재유무_테스트_존재하지않을때(String newCarName) {
        assertThat(carList.isCarExist(newCarName)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"carA", "carB", "carC"})
    public void CarList_자동차존재유무_테스트_존재할때(String newCarName) {
        carList.addCar(newCarName);
        assertThat(carList.isCarExist(newCarName)).isTrue();
    }
}

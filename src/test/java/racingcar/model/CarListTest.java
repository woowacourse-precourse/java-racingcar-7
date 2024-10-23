package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import model.CarList;
import org.junit.jupiter.api.BeforeEach;
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
    void CarList_자동차추가_및_목록반환_테스트(String newCarName) {
        carList.addCar(newCarName);
        assertThat(carList.getCars()).hasSize(1);
    }
}

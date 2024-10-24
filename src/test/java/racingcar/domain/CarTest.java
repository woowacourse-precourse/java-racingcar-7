package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @ParameterizedTest
    @DisplayName("자동차 불가능 이름 확인")
    @ValueSource(strings = {"pobibi", "김형", "김gud", "po bi", ""})
    void checkCarNameError(String testName){
        assertThatThrownBy(() -> new Car(testName))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @DisplayName("자동차 가능 이름 확인")
    @ValueSource(strings = {"pobi", "김", "김gh", "bmw", "bmw-7"})
    void checkCarName(String testName){
        Car car = new Car(testName);

        assertEquals(car.getCarName(), testName);
    }

    @ParameterizedTest
    @DisplayName("자동차 전진 기능 확인")
    @ValueSource(ints = {0, 1, 2, 10, 100, 1000})
    void checkCarStep(int testStepNum){
        Car car = new Car("test");

        for(int i = 0; i < testStepNum; i++){
            car.nextStep();
        }

        assertEquals(car.getStepCount(), testStepNum);
    }
}

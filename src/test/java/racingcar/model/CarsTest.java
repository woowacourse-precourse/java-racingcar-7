package racingcar.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarsTest {
    @Test
    void 차_그룹이_잘_만들어_지는_지_확인() {
        //Given & When
        Cars cars = new Cars("우아한 ,테크 ,코스");
        String[] carNames = {"우아한", "테크", "코스"};
        List<Car> carGroup = cars.getCarGroup();
        SoftAssertions softly = new SoftAssertions();

        //Then
        int i = 0;
        softly.assertThat(carGroup.size()).isEqualTo(3);
        for (Car car : carGroup) {
            softly.assertThat(car.getName()).isEqualTo(carNames[i]);
            i++;
        }
        softly.assertAll();
    }
}

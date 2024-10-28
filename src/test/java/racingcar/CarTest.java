package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("phobi");
        car.updateDistance();
    }

    @Test
    @DisplayName("[기능_테스트]-한 라운드에 대한 출력")
    void carToString_success() {
        //given
        Long distance = car.getDistance();
        String moveDistance = "";
        for(int i = 0; i < distance; i++) {
            moveDistance += "-";
        }

        //when
        String result = car.toString();

        //then
        Assertions.assertThat(result).contains("phobi : ");
        Assertions.assertThat(result).contains(moveDistance);
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest extends NsTest {
    private Car car;

    @BeforeEach
    void setUpCar() {
        car = new Car("conan");
    }

    @Test
    @DisplayName("car 클래스가 정상적으로 생성되는지 테스트")
    void testCarSetUp() {
        assertThat(car.getName()).isEqualTo("conan");
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 횟수가 정상적으로 증가하는지 테스트")
    void testMove() {
        car.move();
        assertThat(car.getMoveCount()).isEqualTo(1);
        car.move();
        assertThat(car.getMoveCount()).isEqualTo(2);
    }


    @Override
    public void runMain() {
        // Application 클래스의 main 메서드를 실행
        Application.main(new String[]{});
    }
}

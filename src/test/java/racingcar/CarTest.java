package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @Test
    @DisplayName("자동차 생성 시 이름이 올바르게 설정되는지 테스트")
    void Car_InputtedCarName_gotCorrectlySetCar() {
        // given
        String name = "Ahn";
        int defaultPosition = 0;

        // when
        Car car = new Car(name);

        // then
        assertThat(name).isEqualTo(car.getName());
        assertThat(defaultPosition).isEqualTo(car.getPosition());
    }
}

package racingcar.customtest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {
    @Test
    void 자동차_이동() {
        Car car = new Car("이동 테스트");
        car.move(Randoms.pickNumberInRange(4, 9));
        assertThat(car.getPosition().equals("-"));
    }

    @Test
    void 자동차_이동_안함() {
        Car car = new Car("이동 테스트");
        car.move(Randoms.pickNumberInRange(0, 3));
        assertThat(car.getPosition().equals(""));
    }

    @Test
    void 이름() {
        Car car = new Car("csw");
        assertThat(car.getName().equals("csw"));
    }


}

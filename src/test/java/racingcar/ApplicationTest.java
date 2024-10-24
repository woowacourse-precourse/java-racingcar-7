package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vehicle.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @DisplayName("자동차_생성_테스트")
    @Test
    void createCar() {
        Car car = new Car("pobi");
        int result = car.getCnt();
        assertThat(0).isEqualTo(result);
        assertThatThrownBy(() -> {
            new Car("javajii");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    /*
        TODO : 사용자 입력받기 테스트 하려고하는데, Console.readLine() 실행 시 에러 발생하는데 이유 찾아보기.
     */

    @DisplayName("자동차_다수_생성_테스트")
    @Test
    void createCars() {
        ArrayList<Car> cars = new ArrayList<>();
        String input = "pobi,woni,jun";
        for (String name : input.split(",")) {
            Car car = new Car(name);
            cars.add(car);
        }
        assertThat(3).isEqualTo(cars.size());
    }


}

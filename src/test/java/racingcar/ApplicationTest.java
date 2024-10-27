package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test // 이름이 5자를 초과하면 IllegalArgumentException 발생
    void carNameValidation() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test // 랜덤 값이 4 이상일 경우 자동차가 전진
    void carMove() {
        Car car = new Car("test");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    private RaceService raceService;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
        cars = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
    }

    @Test
    void raceAndWinnersTest() {
        raceService.moveCars(cars);
        cars.get(0).move(4); // 포비를 우승자로 만듦

        List<String> winners = raceService.getWinners(cars);
        assertThat(winners).contains("pobi");
    }

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
}

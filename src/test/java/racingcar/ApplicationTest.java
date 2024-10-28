package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
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
    @DisplayName("최종 우승자 확인")
    void 최종_우승자_확인() {
        Game game = new Game(cars, 3);
        game.startRace();

        boolean found = false;

        List<String> winners = game.getFinalWinners();
        // 가장 긴 이동 거리 찾기
        int maxLength = cars.stream().mapToInt(Car::getLength).max().getAsInt();

        // 우승자의 최종 이동거리가 maxLength와 같은 길이를 갖고 있는지 확인
        for (String winner : winners) {
            for (Car c : cars) {
                if (c.getName().equals(winner) && c.getLength() == maxLength) {
                    found = true;
                    break;
                }
            }
        }
        assertThat(found).isTrue();
    }

    @Test
    @DisplayName("전진하는 조건 : 0~9사이 무작위 값이 4 이상일 경우에만 이동")
    void 자동차_전진_조건() {
        // given
        Car car = new Car("pobi");
        // 전진 조건 충족하는 무작위 값
        int init_random_val = MOVING_FORWARD;
        // when: 최초 이동
        car.move(init_random_val);
        // 두번째 이동하여 전진 조건 확인
        car.move(car.getLength());
        // then
        assertThat(car.getLength()).isEqualTo(init_random_val+1);
    }

    @Test
    @DisplayName("0~9사이 무작위 값이 4 미만일 경우에는 정지한다")
    void 자동차_정지_조건() {
        // given
        Car car = new Car("pobi");
        // 전진 조건 충족하는 무작위 값
        int init_random_val = STOP;

        // when : 최초 이동
        car.move(init_random_val);
        // 두번째 이동하였으나 전진 조건 불만족
        car.move(car.getLength());

        // then
        assertThat(car.getLength()).isEqualTo(init_random_val);
    }

    @Test
    @DisplayName("입력한 자동차 이름이 5자를 초과하면 예외 발생")
    void 잘못된_입력_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Car("잘못된 이름 입력"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    @DisplayName("입력한 자동차 이름이 5자를 초과하면 예외 발생")
    void 잘못된_자동차_이름_입력() {
        try {
            new Car("이름을 입력했습니다");
        } catch (IllegalArgumentException e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e.getMessage()).contains("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

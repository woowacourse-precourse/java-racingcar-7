package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceGameController;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RaceGameController raceGameController;
    private Car car;


    @BeforeEach
    void setUp() {
        raceGameController = new RaceGameController();
        car = new Car("kgy");
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

    @Test
    void 자동차_이름_5자_초과() {
        assertSimpleTest( () ->
                assertThatThrownBy(() -> runException("kang,geonyoung", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백() {
        assertSimpleTest( () ->
                assertThatThrownBy(() -> runException(" ", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_빈줄() {
        assertSimpleTest( () ->
                assertThatThrownBy(() -> runException("", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 시도_횟수_문자() {
        assertSimpleTest( () ->
                assertThatThrownBy(() -> runException("kang,kgy", "two"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_소수점_숫자() {
        assertSimpleTest( () ->
                assertThatThrownBy(() -> runException("kang,kgy", "0.1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_공백() {
        assertSimpleTest( () ->
                assertThatThrownBy(() -> runException("kang,kgy", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 자동차_객체_리스트_변환() {
        List<Car> cars = new ArrayList<>();
        List<String> carNames = new ArrayList<>(List.of("kang", "geon", "young"));
        cars = raceGameController.convertCars(carNames);

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 무작위_숫자_생성() {
        int randomNumber = car.generateRandomNumber();
        assertThat(randomNumber)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }


    @Test
    void 자동차_한대_참여() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kgy", "3");
                    assertThat(output()).contains("kgy : ---", "최종 우승자 : kgy");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 모든_자동차_공동_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kang,geon,young", "3");
                    assertThat(output()).contains("kang : ---", "geon : ---", "young : ---", "최종 우승자 : kang, geon, young");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Test
    void 게임결과_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kang,geon,young", "3");
                    assertThat(output()).contains("kang : -", "geon : --", "young : ---", "최종 우승자 : young");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

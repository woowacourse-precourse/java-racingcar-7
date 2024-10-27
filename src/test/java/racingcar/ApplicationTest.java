package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

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
    void 이름_여백_처리_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni", "1");
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
    void 빈_문자열_입력_실패_케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_2개_이하_실패_케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("A", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_5자_이상_실패_케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABCDEF", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_알파벳_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("A,B", "case"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_특수문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("A,B", ";"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("A,B", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_0_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("A,B", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 한_라운드_기능_테스트() {
        Cars cars = Cars.newCars();
        cars.addCar(Car.newCar("pobi"));
        cars.addCar(Car.newCar("jini"));

        CarController carController = new CarController();
        OutputView outputView = new OutputView();
        carController.moveOrStopCarsByRandomNumber(cars);
        outputView.printEachRound(cars);
    }

    @Test
    void 우승자_출력_테스트() {
        Cars cars = Cars.newCars();
        Car pobi = Car.newCar("pobi");
        Car jini = Car.newCar("jini");

        pobi.setDistance(1);
        jini.setDistance(3);

        cars.addCar(pobi);
        cars.addCar(jini);

        CarController carController = new CarController();
        Cars winners = carController.getWinners(cars.getCarList());

        assertThat(winners.getCarList().getFirst().getName()).isEqualTo("jini");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 입력_문자열_자르기() {
        String inputCarNames = "박새결,김주아,조성민";
        String[] carNames = RacingCar.splitInputCarNames(inputCarNames);
        RacingCar.checkInputCarNames(carNames);

        for (String carName : carNames) {
            System.out.println("carName = " + carName);
        }

        Assertions.assertThat(carNames.length).isEqualTo(3);

    }

    @Test
    void 입력_자동차_정보_저장() {
        String inputCarNames = "박새결,김주아,조성민";
        String[] carNames = RacingCar.splitInputCarNames(inputCarNames);
        RacingCar.checkInputCarNames(carNames);
        Car cars[] = new Car[carNames.length];
        RacingCar.saveCars(carNames, cars);

        for (Car car : cars) {
            System.out.println("car.getName() = " + car.getName());
            System.out.println("car.getTrial() = " + car.getGo());

        }

    }

    @Test
    void 각차수_실행_결과_출력() {
        String inputCarNames = "박새결,김주아,조성민";
        int inputTrial = 10;
        String[] carNames = RacingCar.splitInputCarNames(inputCarNames);
        RacingCar.checkInputCarNames(carNames);
        Car cars[] = new Car[carNames.length];
        RacingCar.saveCars(carNames, cars);
        RacingCar.outputEachTrial(inputTrial, cars);
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

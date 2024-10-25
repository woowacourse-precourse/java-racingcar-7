package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends NsTest {
    private Main main = new Main();

    @Test
    @DisplayName("자동차 이름을 입력받는다")
    void carNamesInput() {
        assertSimpleTest(() -> {
            run("pobi,woni,jun");
            assertThat(main.receiveCarNames()).isEqualTo("pobi,woni,jun");
        });
    }

    @Test
    @DisplayName("쉼표를 기준으로 자동차 이름을 분리한다")
    void splitCarNames() {
        assertThat(main.splitCarNames("pobi,woni,jun")).isEqualTo(new String[]{"pobi","woni","jun"});
    }

    @Test
    @DisplayName("생성할 자동차의 개수를 확인한다")
    void confirmCarCount() {
        assertThat(main.calculateCarCount(new String[]{"pobi","woni","jun"})).isEqualTo(3);
    }

    @Test
    @DisplayName("단일 자동차 객체를 생성한다")
    void createSingleCar() {
        assertThat(main.createSingleCar("pobi")).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("모든 자동차 객체를 생성한다")
    void createAllCars() {
        assertThat(main.createAllCars(new String[]{"pobi","woni","jun"}))
                .hasSize(3);
    }

    @Test
    @DisplayName("시도할 횟수를 입력받는다")
    void playCountInput() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(main.receivePlayCount()).isEqualTo(5);
        });
    }

    @Test
    @DisplayName("생성된 랜덤 숫자가 범위 내인지 확인한다")
    void checkRandomNumberRange() {
        assertThat(main.createRandomNumber()).isBetween(0,9);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 전진한다")
    void isMove(){
        assertThat(main.isMove(4)).isTrue();
        assertThat(main.isMove(3)).isFalse();
    }

    @Test
    @DisplayName("자동차 이동 여부가 잘 변경되는지 확인한다")
    void checkCarMoveInformation() {
        Car car = new Car("pobi",false);
        main.setMoveInformation(car, true);
        assertThat(car.getMove()).isTrue();
    }

    @Override
    protected void runMain() {

    }
}
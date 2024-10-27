package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceControllerTest extends NsTest {
    private RaceController raceController = new RaceController();

    @Test
    @DisplayName("단독 우승자를 선정한다")
    void selectSingleWinner() {
        Car car = new Car("pobi", 0);
        Car car2 = new Car("jun", 1);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);
        assertThat( raceController.selectWinners(cars)).isEqualTo(List.of("jun"));
    }

    @Test
    @DisplayName("공동 우승자를 출력한다")
    void selectMultiWinners() {
        Car car = new Car("pobi", 1);
        Car car2 = new Car("jun", 1);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);
        assertThat( raceController.selectWinners(cars)).isEqualTo(List.of("pobi", "jun"));
    }

    @Test
    @DisplayName("반복 횟수에 숫자가 아닌 것을 입력하면 예외가 발생한다")
    void playCountFormatError(){
        assertSimpleTest(()-> {
            run("삼");
                    assertThatThrownBy(() -> raceController.validatePlayCount())
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Test
    @DisplayName("반복 횟수에 숫자를 입력하면 예외가 발생하지 않는다")
    void playCountValidFormat(){
        assertSimpleTest(()-> {
            run("5");
                    assertThatCode(() -> raceController.validatePlayCount())
                            .doesNotThrowAnyException();
                }
        );
    }
    @Test
    @DisplayName("반복 횟수에 0 이하이거나 10 초과 값을 입력하면 예외가 발생한다")
    void playCountLimitError(){
        assertSimpleTest(()-> {
            run("0");
                    assertThatThrownBy(() -> raceController.validatePlayCount())
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Test
    @DisplayName("반복 횟수에 1에서 9사이의 숫자를 입력하면 예외가 발생하지 않는다")
    void playCountValidLimit(){
        assertSimpleTest(()-> {
            run("5");
                    assertThatCode(() -> raceController.validatePlayCount())
                            .doesNotThrowAnyException();
                }
        );
    }

    @Override
    protected void runMain() {

    }
}
package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("참가 자동차 입력 테스트입니다.")
    void carInputTest() {
        //given
        String input = "pobi, woni, jun";
        //when
        List<Car> cars = Application.createParticipant(input);
        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getCarName()).isEqualTo("pobi");
        assertThat(cars.get(1).getCarName()).isEqualTo("woni");
        assertThat(cars.get(2).getCarName()).isEqualTo("jun");

    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열 일 경우 예외처리 테스트입니다.")
    void carNameEmptyInputTest() {
        //given
        String input = " , javaji";
        //when, then
        assertThrows(
                CarNameInputException.class,
                () -> Application.createParticipant(input));
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일 경우 예외처리 테스트입니다.")
    void carNameTooLongInputTest() {
        //given
        String input = "hahahahah, ijij, kk";
        //when, then
        assertThrows(
                CarNameInputException.class,
                () -> Application.createParticipant(input));
    }

    @Test
    @DisplayName("횟수를 음수로 입력할 경우 예외처리 테스트입니다.")
    void negativeNumberInputTest() {
        //given
        int n = -1;
        //when, then
        assertThrows(
                NumberInputException.class,
                () -> {
                    throw new NumberInputException();
                }
        );
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 경우 자동차가 이동하는지 확인하는 테스트 입니다.")
    void moveWhenNumberIsGraterThanOrEqualFour() {
        //given
        Car car = new Car("pobi");
        //when
        for (int i = 0; i < 100; i++) {
            car.isMove();
        }
        //then
        assertThat(car.getPosition() > 0);
    }

    @Test
    @DisplayName("자동차가 최대로 많이 이동한 값을 잘 찾아오는지 확인하는 테스트 입니다.")
    void carMaxMoveTest() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("pobi");
        car1.moveForward();
        car1.moveForward();
        car1.moveForward();
        Car car2 = new Car("woni");
        car2.moveForward();
        car2.moveForward();
        Car car3 = new Car("jun");
        car3.moveForward();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        //when
        int maxMoveDistance = Application.calMaxMove(cars);
        //then
        assertEquals(3, maxMoveDistance);
    }

    @Test
    @DisplayName("게임 결과를 잘 계산하는지 (우승자를 잘 가져오는지) 확인하는 테스트 입니다.")
    void findWinnersTest() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("pobi");
        car1.moveForward();
        car1.moveForward();
        car1.moveForward();
        Car car2 = new Car("woni");
        car2.moveForward();
        car2.moveForward();
        car2.moveForward();
        Car car3 = new Car("jun");
        car3.moveForward();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        //when
        List<String> winners = Application.findWinners(cars, 3);
        //then
        List<String> expectedWinners = List.of("pobi", "woni");
        assertEquals(expectedWinners, winners);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

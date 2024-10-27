package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarGame;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // 자동차 움직임 테스트
    @Test
    @DisplayName("car move test")
    void testCarMove() {
        Car moveCar = new Car("move");
        int carDistance = moveCar.getDistance();
        moveCar.move();
        // 자동차가 움직였을 수도 있고 안 움직였을 수도 있음. 따라서 거리 증가 여부만 확인.
        assertTrue(moveCar.getDistance() == carDistance || moveCar.getDistance() == carDistance + 1);
    }

    // 자동차 객체 생성 테스트
    @Test
    @DisplayName("car create test")
    void testCreateCar() {
        String[] carNames = {"createCar1", "createCar2", "createCar3"};
        List<Car> createCars = CarGame.createCar(carNames);

        assertEquals(3, createCars.size());
        assertEquals("createCar1", createCars.get(0).getName());
        assertEquals("createCar2", createCars.get(1).getName());
        assertEquals("createCar3", createCars.get(2).getName());
    }

    // 최대 전진 횟수 구하기 테스트
    @Test
    @DisplayName("find max distance test")
    void testFindMaxDistance() {
        Car maxCar1 = new Car("maxCar1");
        Car maxCar2 = new Car("maxCar2");
        Car maxCar3 = new Car("maxCar3");

        // 전진할 때까지 move
        while(maxCar1.getDistance() > 0){
            maxCar1.move();
        }

        List<Car> cars = List.of(maxCar1, maxCar2, maxCar3);
        int maxDistance = CarGame.findMaxDistance(cars);

        assertEquals(maxCar1.getDistance(), maxDistance);
    }


    // 최대 전진 횟수를 가지는 자동차 이름 구하기 테스트
    // 최종 우승 자동차 구하기 테스트
    @Test
    @DisplayName("find winner test")
    void testFindWinner() {
        Car winnerCar1 = new Car("winnerCar1");
        Car winnerCar2 = new Car("winnerCar2");
        Car winnerCar3 = new Car("winnerCar3");

        //// winner는 winnerCar1과 winnerCar2로 설정 후 테스트
        // 전진할 때까지 move
        while(winnerCar1.getDistance() == 0){
            winnerCar1.move();
        }
        // 전진할 때까지 move
        while(winnerCar2.getDistance() == 0){
            winnerCar2.move();
        }

        List<Car> findWinnerCars = List.of(winnerCar1, winnerCar2, winnerCar3);
        int maxDistance = CarGame.findMaxDistance(findWinnerCars);
        List<String> winners = CarGame.findWinner(findWinnerCars, maxDistance);

        assertEquals(2, winners.size());
        assertEquals("winnerCar1", winners.get(0));
        assertEquals("winnerCar2", winners.get(1));
    }
}

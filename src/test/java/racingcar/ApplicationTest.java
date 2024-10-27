package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.DuplicateCarException;
import racingcar.game.Game;
import racingcar.io.OutputManager;
import racingcar.vehicle.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

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
    void createCarTest() {
        Car car = new Car("pobi");
        int result = car.getCnt();
        assertThat(0).isEqualTo(result);
    }

    @DisplayName("자동차 생성 이름 길이 테스트")
    @Test
    void createCarValidationTest() {
        assertThatThrownBy(() -> {
            new Car("javajii");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 Null 입력 테스트")
    @Test
    void createCarNullTest() {
        assertThatThrownBy(() ->
                new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 공백 테스트")
    @Test
    void createCarBlankTest() {
        try {
            Car car = new Car("");
            fail();
            Assertions.assertEquals("", car.getName());
        } catch (IllegalArgumentException e) {

        }
    }

    @DisplayName("자동차_다수_생성_테스트")
    @Test
    void createCarsTest() {
        ArrayList<Car> cars = new ArrayList<>();
        String input = "pobi,woni,jun";
        for (String name : input.split(",")) {
            Car car = new Car(name);
            cars.add(car);
        }
        assertThat(3).isEqualTo(cars.size());
    }

    @DisplayName("자동차_전진_출력_테스트")
    @Test
    void goCarTest() {
        Car car = new Car("pobi");
        car.run(MOVING_FORWARD);
        assertThat(1).isEqualTo(car.getCnt());
    }

    @DisplayName("랜덤 음수 값 테스트")
    @Test
    void negativeRandomNumberTest() {
        Car car = new Car("pobi");
        assertThatThrownBy(() -> car.run(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차_여러대_전진_출력_테스트")
    @Test
    void goCarsTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));
        int randomNum = Randoms.pickNumberInRange(0, 9);
        cars.forEach(car -> car.run(randomNum));
    }

    @DisplayName("우승자_중복_테스트")
    @Test
    void winnerTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));
        Game game = new Game();
        int randomNum = Randoms.pickNumberInRange(5, 9);
        cars.forEach(car -> car.run(randomNum));
    }

    @DisplayName("assertRandomNumberInRangeTest 테스트")
    @Test
    void pickNumberInListTest() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni,jun", "1");
            assertThat(output()).contains("최종 우승자 : jun");
        }, STOP, STOP, MOVING_FORWARD);
    }

    @DisplayName("HashMap으로 자료구조 변경테스트")
    @Test
    void hashMapTest() {
        HashMap<String, Car> cars = new HashMap<>();
        Game game = new Game();
        Assertions.assertThrows(DuplicateCarException.class, () -> game.assignPlayer("pobi,woni,jun,jun"));
//
//        for (String carName : cars.keySet()) {
//            Car car = cars.get(carName);
//            car.run(4);
//        }
//
//        int max = cars.values().stream().mapToInt(Car::getCnt).max().orElseThrow();
//        List<String> result =  cars.values().stream().filter((car) -> car.getCnt() == max).map(Car::getName).toList();
//        OutputManager.getInstance().print("최종 우승자 : " + String.join(", ", result));
    }

    @DisplayName("HashMap game start 테스트")
    @Test
    void HashMapGameStartTest() {
        Game game = new Game();
        HashMap<String, Car> result = game.gameStart("pobi,woni,jun", "1");
        assertThat(3).isEqualTo(result.size());
    }

    @DisplayName("HashMap game winner 테스트")
    @Test
    void HashMapGameWinnerTest() {
        Game game = new Game();
        HashMap<String, Car> result = game.gameStart("pobi,woni,jun", "1");
        game.winnerPlayer(result);
    }

    @DisplayName("HashMap 실행 테스트")
    @Test
    void HashMapAppTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("HashMap 자동차 이름 출력 테스트")
    @Test
    void HashMapPrintCarNameTest() {
        Game game = new Game();
        game.gameStart("pobi,woni,jun,buk,abc", "10");
    }
}

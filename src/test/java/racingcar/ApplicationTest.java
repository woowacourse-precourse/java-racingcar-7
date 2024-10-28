package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.CarController;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import org.junit.jupiter.api.Test;
import service.CarService;

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

    @Test
    public void inputCarNamesTest() {
        CarController carController = new CarController();

        String carNamesInput = "포르쉐,페라리,람보르기니";

        List<Car> cars = carController.createCars(carNamesInput);

        assertEquals(3, cars.size());
        assertEquals("포르쉐", cars.get(0).getName());
        assertEquals("페라리", cars.get(1).getName());
        assertEquals("람보르기니", cars.get(2).getName());
    }

    @Test
    public void CarValueAssignerTest() {

        CarService carService = new CarService();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("포르쉐"));
        cars.add(new Car("페라리"));
        cars.add(new Car("람보르기니"));

        carService.assignRandomValueToAllCars(cars);

        for (Car car : cars) {
            int randomValue = car.getRandomValue(); // 랜덤 값 가져오기
            assertTrue(randomValue >= 1 && randomValue <= 10); // 범위 확인
        }
    }

    @Test
    public void updateScoreBasedOnComparisonTest() {

        CarService carService = new CarService();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("포르쉐", 4));
        cars.add(new Car("페라리", 5));
        cars.add(new Car("람보르기니", 3));

        for (Car car : cars) {
            int randomValue = car.getRandomValue(); // 랜덤 값 가져오기
            carService.updateScoreIfNeeded(car, car.getRandomValue());
        }

        assertEquals(1, cars.get(0).getScore());
        assertEquals(1, cars.get(1).getScore());
        assertEquals(0, cars.get(2).getScore());

    }

    @Test
    public void displayRoundScoresTest() {

        CarService carService = new CarService();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("포르쉐", 4));
        cars.add(new Car("페라리", 5));
        cars.add(new Car("람보르기니", 3));

        for (Car car : cars) {
            int randomValue = car.getRandomValue(); // 랜덤 값 가져오기
            carService.updateScoreIfNeeded(car, randomValue);
        }

        assertThat(output()).contains("포르쉐 : -", "페라리 : -", "람보르기니 :");

    }

    @Test
    public void displayWinnerTest() {

        List<Car> cars = new ArrayList<>();

        CarController carController = new CarController();
        cars.add(new Car("포르쉐", 4, 3));
        cars.add(new Car("페라리", 5, 3));
        cars.add(new Car("람보르기니", 3, 1));

        carController.displayWinners(cars);

        assertThat(output()).contains("최종 우승자 : 포르쉐, 페라리");

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

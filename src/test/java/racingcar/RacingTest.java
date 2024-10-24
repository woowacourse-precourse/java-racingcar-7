package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void moveConditionTest() {
        assertRandomNumberInRangeTest(() -> {
                    boolean move = Racing.moveCondition();
                    assertThat(move).isEqualTo(true);
                }, MOVING_FORWARD
        );
    }

    @Test
    void moveTest() {
        assertSimpleTest(() -> {
                    Car car = new Car("car",2);
                    Racing.move(car);
                    assertThat(car.name).isEqualTo("car");
                    assertThat(car.position).isEqualTo(3);
                }
        );
    }

    @Test
    void raceTest() {
        assertRandomNumberInRangeTest(() -> {
                    ArrayList<Car> cars = new ArrayList<Car>();
                    Car car = new Car("car",2);
                    cars.add(car);

                    Racing.race(cars);
                    assertThat(car.name).isEqualTo("car");
                    assertThat(car.position).isEqualTo(2);

                    Racing.race(cars);
                    assertThat(car.name).isEqualTo("car");
                    assertThat(car.position).isEqualTo(3);
                }, STOP, MOVING_FORWARD
        );
    }

    @Test
    void getMaxPositionTest() {
        assertSimpleTest(() -> {
                    ArrayList<Integer> positions = new ArrayList<Integer>();
                    positions.add(3);
                    positions.add(1);
                    positions.add(2);
                    positions.add(3);

                    Integer maxPosition = Racing.getMaxPosition(positions);
                    assertThat(maxPosition).isEqualTo(3);
                }
        );
    }

    @Test
    void getWinnersTest() {
        assertSimpleTest(() -> {
                    ArrayList<Car> cars = new ArrayList<Car>();
                    cars.add(new Car("1",2));
                    cars.add(new Car("2",3));

                    ArrayList<String> winners = Racing.getWinners(cars);
                    ArrayList<String> expected = new ArrayList<String>();
                    expected.add("2");

                    assertThat(winners).isEqualTo(expected);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

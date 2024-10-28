package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsInRaceTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private CarsInRace carsInRace;

    private static boolean canMove = true;
    private static boolean cannotMove = false;

    @BeforeEach
    public void 기본_설정() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");
        carsInRace = new CarsInRace(List.of(car1, car2, car3));
    }

    @Test
    public void 우승자를_선정한다_1명일_경우() {
        // when
        car1.move(canMove);
        car2.move(cannotMove);
        car3.move(cannotMove);
        List<String> winners = carsInRace.getWinnersName();

        // then
        assertThat(winners).contains("car1");
    }

    @Test
    public void 우승자를_선정한다_2명_이상일_경우() {
        // when
        car1.move(cannotMove);
        car2.move(canMove);
        car3.move(canMove);
        List<String> winners = carsInRace.getWinnersName();

        // then
        assertThat(winners).contains("car2", "car3");
    }
}

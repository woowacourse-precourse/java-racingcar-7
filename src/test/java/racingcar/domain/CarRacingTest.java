package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

    private List<Car> cars;
    private CarRacing carRacing;

    @BeforeEach
    void setUp() {
        cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        carRacing = new CarRacing(cars);
    }

    @Test
    void 경주_참여_자동차_수_확인() {
        assertEquals(3, carRacing.getCars().size());
    }
}

package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exceptions.InvalidInputException;
import racingcar.model.car.MockCar;
import racingcar.model.game.Race;
import racingcar.service.CarService;
import racingcar.service.RaceCarService;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    @Test
    void 레이스_시뮬레이션_확인_1() {
        MockCar car1 = new MockCar("A");
        MockCar car2 = new MockCar("B");

        Race race = new Race(0);
        race.addCar(car1);
        race.addCar(car2);

        List<String> winners = race.simulate();
        Assertions.assertThat(winners).containsExactly("A", "B");
    }

    @Test
    void 레이스_시뮬레이션_확인_2() {
        MockCar car1 = new MockCar("A");
        MockCar car2 = new MockCar("B");

        Race race = new Race(5);
        race.addCar(car1);
        race.addCar(car2);

        List<String> winners = race.simulate();
        Assertions.assertThat(winners).containsExactly("A", "B");
    }

    @Test
    void 레이스_시도횟수_음수() {
        assertThrows(InvalidInputException.class, () -> {
            new Race(-1);
        });
    }

    @Test
    void 차량_생성() {
        CarService service = new RaceCarService();
        service.createCars("A,B,C");
        Assertions.assertThat(service.createCars("A,B,C"))
                .contains(new MockCar("A"), new MockCar("B"), new MockCar("C"));
    }

    @Test
    void 차량_생성_예외() {
        CarService service = new RaceCarService();
        assertThrows(InvalidInputException.class, () -> service.createCars(""));
    }
}

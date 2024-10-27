package racingcar.io;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.race.MockCar;
import racingcar.race.racer.car.Car;

class CarOutputHandlerTest {

    CarOutputHandler carOutputHandler = new CarOutputHandler();

    @Test
    void 경기_결과_출력(){
        List<Car> cars = new ArrayList<>();
        cars.add(new MockCar("pobi", "-"));
        cars.add(new MockCar("woni", ""));
        cars.add(new MockCar("jun", "-"));

        carOutputHandler.printRaceResult(cars);
    }

    @Test
    void 우승자_출력() {
        List<String> winners = new ArrayList<>();
        winners.add("woni");
        winners.add("pobi");

        carOutputHandler.printWinner(winners);
    }
}
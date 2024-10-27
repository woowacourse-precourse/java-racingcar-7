package racingcar.test.serviceTest.evaluatorTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import racingcar.model.RacingCar;
import racingcar.service.evaluator.WinnerEvaluator;
import racingcar.service.evaluator.WinnerEvaluatorEmb;
import racingcar.service.factory.CarFactory;
import racingcar.service.factory.CarFactoryEmb;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnerEvaluatorTestEmb implements WinnerEvaluatorTest {

    public List<RacingCar> setCarFactory() {
        ArrayList<String> carNames = new ArrayList<>();
        CarFactory carFactory = new CarFactoryEmb();
        carNames.add("A");
        carNames.add("B");
        carNames.add("C");
        return carFactory.createCars(carNames);
    }

    @Test
    public void testDetermineWinners() {
        List<RacingCar> cars = setCarFactory();
        cars.get(0).increaseDistance().increaseDistance();
        cars.get(1).increaseDistance();
        WinnerEvaluator winnerEvaluator = new WinnerEvaluatorEmb();
        assertThat(winnerEvaluator.determineWinners(cars).size()).isEqualTo(1);
        assertThat(winnerEvaluator.determineWinners(cars).getFirst().getName()).isEqualTo("A");
    }

    @Test
    public void testFindMaxDistance() {
        List<RacingCar> cars = setCarFactory();
        cars.get(0).increaseDistance().increaseDistance();
        cars.get(1).increaseDistance();
        WinnerEvaluator winnerEvaluator = new WinnerEvaluatorEmb();
        assertThat(winnerEvaluator.findMaxDistance(cars)).isEqualTo(2);
    }

    @Test
    public void testCollectWinners() {
        List<RacingCar> cars = setCarFactory();
        cars.get(0).increaseDistance().increaseDistance();
        cars.get(1).increaseDistance();
        WinnerEvaluator winnerEvaluator = new WinnerEvaluatorEmb();
        assertThat(winnerEvaluator.collectWinners(cars,2).size()).isEqualTo(1);
        assertThat(winnerEvaluator.collectWinners(cars,2).getFirst().getName()).isEqualTo("A");
    }

    @Test
    public void run() {
        testCollectWinners();
        testDetermineWinners();
        testFindMaxDistance();
    }
}

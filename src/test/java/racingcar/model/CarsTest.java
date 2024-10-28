package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.constant.RegisterCarNumberConstant.PRIME_CAR_DISTANCE;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.exception.carName.DuplicateCarNameException;
import racingcar.service.GameService;

class CarsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 2;

    GameService gameService = new GameService();

    private Cars createTestCars() {
        return new Cars(List.of(
                new Car("BMW", PRIME_CAR_DISTANCE.getValue()),
                new Car("Audi", PRIME_CAR_DISTANCE.getValue())
        ));
    }

    @Test
    void moveOneTurn() {
        Cars cars = createTestCars();
        assertRandomNumberInRangeTest(
                () -> {
                    Cars results = cars.moveOneTurn(gameService);
                    assertThat(results.carsToString()).contains("BMW : -", "Audi : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void duplicateValidation() {
        Cars cars = createTestCars();
        assertTrue(cars.duplicateValidation());
    }

    @Test
    void duplicateValidationException() {
        Cars cars = new Cars(List.of(
                new Car("BMW", PRIME_CAR_DISTANCE.getValue()),
                new Car("BMW", PRIME_CAR_DISTANCE.getValue()),
                new Car("Audi", PRIME_CAR_DISTANCE.getValue())
        ));

        assertThrows(DuplicateCarNameException.class, cars::duplicateValidation);
    }

    @Test
    void carsToString() {
        Cars cars = createTestCars();
        List<String> expectedStrings = List.of("BMW : ", "Audi : ");
        assertEquals(expectedStrings, cars.carsToString());
    }

    @Test
    void carsToName() {
        Cars cars = createTestCars();
        List<String> expectedNames = List.of("BMW", "Audi");
        assertEquals(expectedNames, cars.carsToName());
    }

    @Test
    void sortCarsToDescendingOrder() {
        Cars cars = createTestCars();
        assertRandomNumberInRangeTest(
                () -> {
                    Cars results = cars.moveOneTurn(gameService);
                    Cars sortedResults = results.sortCarsToDescendingOrder();
                    List<String> expectedOrder = List.of("Audi : -", "BMW : ");
                    assertEquals(sortedResults.carsToString(), expectedOrder);
                },
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void findWinners() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> createSortedCarList = List.of(
                            new Car("BMW", 3),
                            new Car("Audi", 2),
                            new Car("Benz", 1)
                    );

                    Cars createSortedCars = new Cars(createSortedCarList);

                    List<Car> winner = List.of(new Car("BMW", 3));
                    Cars expectedWinner = new Cars(winner);
                    assertEquals(createSortedCars.findWinners(), expectedWinner);
                },
                STOP, MOVING_FORWARD
        );
    }
}
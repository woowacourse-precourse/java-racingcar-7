package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {
    private CarManager carManager;

    @BeforeEach
    public void setUp() {
        carManager = new CarManager();
    }

    @Test
    void createCarsAndGetCars() {
        String[] input = {"do", "rae", "mi"};
        carManager.createCars(input);

        List<Car> cars = carManager.getCars();

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("do");
        assertThat(cars.get(1).getName()).isEqualTo("rae");
        assertThat(cars.get(2).getName()).isEqualTo("mi");

    }
}


package racingcar.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.repository.CarRepository;

public class CarRepositoryTest {

    private final CarRepository carRepository = CarRepository.getInstance();


    @Test
    @DisplayName("carRepository 테스트")
    public void testCarRepository() {

        //given :this.carRepository
        Car exCar1 = new Car("car1");
        Car exCar2 = new Car("car2");
        Car exCar3 = new Car("car3");

        List<Car> exCarList = List.of(exCar2, exCar3);

        Round exRound = new Round.Builder()
                .thisRound(3)
                .build();

        //when
        exCar1 = carRepository.saveAndReturn(exCar1);
        exCar2 = carRepository.saveAndReturn(exCar2);
        exCar3 = carRepository.saveAndReturn(exCar3);

        exRound.addCar(exCar1);
        exRound.addCar(exCar2);

        carRepository.update(exCar3);

        //then
        assertEquals(carRepository.findByCarId(exCar1.getId()), exCar1);
        assertEquals(carRepository.findByCarId(exCar2.getId()), exCar2);

        assertEquals(carRepository.findByCarName("car1"), exCar1);
        assertEquals(carRepository.findByCarName("car2"), exCar2);
    }


}

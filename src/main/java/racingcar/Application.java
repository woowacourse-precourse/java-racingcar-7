package racingcar;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingCarRepository;
import racingcar.service.CarService;
import racingcar.service.RacingCarService;

public class Application {
    public static void main(String[] args) {
        CarRepository carRepository = new RacingCarRepository();
        CarService carService = new RacingCarService(carRepository);

        Car car = new Car("pobi");
        carService.register(car);

        Car savedCar = carService.getCar("pobi");
        System.out.println("savedCar.equals(car) : " + savedCar.equals(car));
    }
}

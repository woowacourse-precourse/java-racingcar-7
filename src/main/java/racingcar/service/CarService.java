package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void joinCar(Car car) {
        validateDuplicateCar(car);
        carRepository.save(car);
    }

    private void validateDuplicateCar(Car car) {
        carRepository.findByName(car.getName())
                .ifPresent(m -> {
                    throw new IllegalArgumentException("중복된 회원 존재");
                });
    }

    public void moveCar() {
        List<Car> cars = carRepository.findAll();

        cars.forEach(car -> {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                car.move();
            }
        });
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<String> findWinners() {
        List<Car> cars = carRepository.findAll();
        List<String> winner = new ArrayList<>();
        int winnerRecord = -1;

        for (Car car : cars) {
            int carRecord = car.getCount();

            if (carRecord > winnerRecord) {
                winner.clear();
                winner.add(car.getName());
                winnerRecord = carRecord;
            } else if (carRecord == winnerRecord) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

}

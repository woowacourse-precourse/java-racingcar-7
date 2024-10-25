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

    public void initCars(List<String> nameList){
        nameList.forEach(name -> {
            carRepository.save(new Car(name));
        });
    }

    public List<Car> playRound(){
        List<Car> cars = carRepository.findAll();

        cars.forEach(car -> {
            car.move(Randoms.pickNumberInRange(0, 9));
        });

        return cars;
    }

    public List<String> getWinners(){
        List<Car> cars = carRepository.findAll();

        return findWinners(cars);
    }

    private List<String> findWinners(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();

        int maxMoveCount = Integer.MIN_VALUE;
        for (Car car : cars) {
            int currentCarMoveCount = car.getMoveCount();
            if (currentCarMoveCount > maxMoveCount) {
                winnerNames.clear();
                maxMoveCount = currentCarMoveCount;
            }
            if (currentCarMoveCount >= maxMoveCount) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

}

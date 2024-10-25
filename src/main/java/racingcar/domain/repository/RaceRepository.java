package racingcar.domain.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RaceRepository {
    //----- 싱글톤 패턴 적용 -----//
    private static final RaceRepository instance = new RaceRepository();
    private RaceRepository(){}
    public static RaceRepository getInstance() {
        return instance;
    }
    //----- 싱글톤 패턴 적용 -----//

    private final List<Car> carRepository = new ArrayList<>();

    public void saveAll(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            save(car);
        }
    }

    private void save(Car car) {
        carRepository.add(car);
    }

    public Car findByCarName(String name) {
        return carRepository.stream().filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}

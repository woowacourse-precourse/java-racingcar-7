package racingcar.domain.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

/**
 * packageName    : racingcar.domain.repository
 * fileName       : CarRepository
 * author         : ehgur
 * date           : 2024-10-27
 * description    : Car 저장소
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-27        ehgur             최초 생성
 */

public class CarRepository {
    //----- 싱글톤 패턴 적용 -----//
    private static final CarRepository instance = new CarRepository();
    private CarRepository(){}
    public static CarRepository getInstance() {
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

    public List<Car> findAll() {
        return carRepository;
    }

    public void deleteAll() {
        carRepository.clear();
    }
}

package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarsSaveRequestDto;
import racingcar.domain.repository.CarRepository;
import racingcar.validation.CarNameValidator;

/**
 * packageName    : racingcar.service
 * fileName       : CarService
 * author         : ehgur
 * date           : 2024-10-27
 * description    : Car 관련 기능 구현
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-27        ehgur             최초 생성
 */

public class CarService {
    //----- 싱글톤 패턴 적용 -----//
    private static final CarService instance = new CarService();
    private final CarRepository carRepository = CarRepository.getInstance();

    private CarService() {
    }

    public static CarService getInstance() {
        return instance;
    }
    //------------------------//

    public void saveAll(CarsSaveRequestDto requestDto) {
        Cars cars = new Cars(requestDto.toEntity());
        carRepository.saveAll(cars);
    }

    public void isCarNameValid(CarsSaveRequestDto requestDto) {
        CarNameValidator.run(requestDto);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }
}

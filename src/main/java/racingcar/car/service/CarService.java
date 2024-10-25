package racingcar.car.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.domain.Car;
import racingcar.car.repository.CarRepository;
import racingcar.car.service.dto.CarCreateReqDto;
import racingcar.constant.ErrorStatus;

public class CarService {

	private final CarRepository carRepository;

	private CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	private static class CarServiceHolder {
		private static final CarService INSTANCE = new CarService(CarRepository.getInstance());
	}

	public static CarService getInstance() {
		return CarService.CarServiceHolder.INSTANCE;
	}

	public void saveCars(List<CarCreateReqDto> createReqDtos) {
		List<Car> cars = new ArrayList<>();
		for (CarCreateReqDto createReqDto : createReqDtos) {
			isValidName(createReqDto.getCarName());
			cars.add(Car.from(createReqDto));
		}
		carRepository.saveAll(cars);
	}

	private void isValidName(String name) {
		if (name.length() > 5)
			throw new IllegalArgumentException("자동차의 이름이 5자를 넘습니다.");
	}

	private void isPossibleCount(Integer count) {
		if (count > 10000 || count <= 0)
			throw new IllegalArgumentException(ErrorStatus.INVALID_NUMBER_RANGE.getMessage());
	}
}

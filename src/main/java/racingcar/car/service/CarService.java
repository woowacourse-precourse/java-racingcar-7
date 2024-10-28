package racingcar.car.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.domain.Car;
import racingcar.car.repository.CarRepository;
import racingcar.car.service.dto.CarCreateReqDto;
import racingcar.car.service.dto.CarMoveRespDto;
import racingcar.car.service.dto.WinnerRespDto;
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
		List<Car> cars = createReqDtos.stream()
			.map(carCreateReqDto -> {
				isValidName(carCreateReqDto.getCarName());
				return Car.from(carCreateReqDto);
			})
			.toList();
		carRepository.saveAll(cars);
	}

	public List<CarMoveRespDto> moveCars() {
		List<Car> cars = carRepository.findAll();
		cars.forEach(car -> {
			if (4 <= Randoms.pickNumberInRange(0, 9)) {
				car.move();
			}
		});
		return cars.stream()
			.map(CarMoveRespDto::from)
			.toList();
	}

	public List<WinnerRespDto> calculateWinners() {
		return carRepository.findTopOrderByPosition()
			.stream()
			.map(WinnerRespDto::from)
			.toList();
	}

	private void isValidName(String name) {
		if (name.length() > 5)
			throw new IllegalArgumentException("자동차의 이름이 5자를 넘습니다.");
	}

	public void isPossibleCount(Integer count) {
		if (count >= 10000 || count <= 0)
			throw new IllegalArgumentException(ErrorStatus.INVALID_NUMBER_RANGE.getMessage());
	}
}

package racingcar.car.service;

import static racingcar.car.constant.RacingLimit.*;

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
			if (MIN_MOVE_NUMBER.getNumber() <= Randoms.pickNumberInRange(RANDOM_MIN.getNumber(), RANDOM_MAX.getNumber())) {
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
		if (name.length() > MAX_CAR_NAME_LENGTH.getNumber())
			throw new IllegalArgumentException(ErrorStatus.CAR_NAME_RANGE.getMessage());
	}

	public void isPossibleCount(Integer count) {
		if (count > MAX_COUNT.getNumber() || count < MIN_COUNT.getNumber())
			throw new IllegalArgumentException(ErrorStatus.INVALID_NUMBER_RANGE.getMessage());
	}
}

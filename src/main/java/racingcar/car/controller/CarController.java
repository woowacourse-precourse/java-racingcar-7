package racingcar.car.controller;

import java.util.List;

import racingcar.car.service.CarService;
import racingcar.car.service.dto.CarCreateReqDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
	private final CarService carService;
	private final InputView inputView;
	private final OutputView outputView;

	private CarController(CarService carService, InputView inputView, OutputView outputView) {
		this.carService = carService;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	private static class CarControllerHolder {
		private static final CarController INSTANCE = new CarController(CarService.getInstance(),
			InputView.getInstance(), OutputView.getInstance());
	}

	public static CarController getInstance() {
		return CarControllerHolder.INSTANCE;
	}

	public void createCars() {
		List<String> names = inputView.readCarInput();
		List<CarCreateReqDto> createReqDtos = names.stream()
			.map(CarCreateReqDto::new)
			.toList();
		carService.saveCars(createReqDtos);
	}
}

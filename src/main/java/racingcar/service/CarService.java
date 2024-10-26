package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;
import racingcar.validator.Validator;
import racingcar.validator.impl.NameValidator;

public class CarService {
    CarRepository carRepository;
    Validator validator;

    public CarService() {
        this.carRepository = new CarRepositoryImpl();
        this.validator = new NameValidator();
    }

    public void inputRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();

        carNameInput = carNameInput.replaceAll(" ", "");
        List<String> carNames = List.of(carNameInput.split(","));
        validator.validate(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        carRepository.saveAll(cars);

        Console.close();
    }
}

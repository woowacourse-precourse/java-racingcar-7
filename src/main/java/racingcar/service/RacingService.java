package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;
import racingcar.validator.Validator;
import racingcar.validator.impl.NameValidator;
import racingcar.validator.impl.NumberValidator;

public class RacingService {
    CarRepository carRepository;
    Validator validator;

    public RacingService() {
        this.carRepository = new CarRepositoryImpl();
        this.validator = new NumberValidator();
    }

    public void race() {
        int count = inputFrequency();

        List<Car> cars = carRepository.findAll();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.moveOrStop();
                System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
            }
            System.out.println();
        }
    }

    private int inputFrequency() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();
        validator.validate(numberInput);
        Console.close();

        return Integer.parseInt(numberInput);
    }
}

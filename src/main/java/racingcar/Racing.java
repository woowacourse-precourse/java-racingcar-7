package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;

public class Racing {
    public void race() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        List<String> carNames = List.of(carNameInput.split(","));

        CarRepository carRepository = new CarRepositoryImpl();

        for (String carName : carNames) {
            Car car = new Car(carName);
            carRepository.save(car);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();
        int number = Integer.parseInt(numberInput);

        List<Car> cars = carRepository.findAll();

        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                car.moveOrStop();
                System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
            }
        }

        Console.close();
    }
}

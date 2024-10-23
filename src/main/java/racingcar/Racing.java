package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;
import racingcar.util.Validator;
import racingcar.util.impl.NameValidator;
import racingcar.util.impl.NumberValidator;

public class Racing {
    CarRepository carRepository = new CarRepositoryImpl();
    Validator nameValidator = new NameValidator();
    Validator numberValidator = new NumberValidator();

    public void race() {
        inputRacingCar();

        int number = inputFrequency();
        printExecution(number);

        int maxDistance = countMaxDistance();
        List<Car> winners = decisionWinners(maxDistance);

        printWinners(winners);

        Console.close();
    }

    private void inputRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        List<String> carNames = List.of(carNameInput.split(","));
        nameValidator.validate(carNames);

        for (String carName : carNames) {
            Car car = new Car(carName);
            carRepository.save(car);
        }
    }

    private int inputFrequency() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();
        numberValidator.validate(numberInput);
        int number = Integer.parseInt(numberInput);

        return number;
    }

    private void printExecution(int number) {
        List<Car> cars = carRepository.findAll();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                car.moveOrStop();
                System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
            }
            System.out.println();
        }
    }

    private int countMaxDistance() {
        List<Car> carsResult = carRepository.findAll();
        int maxDistance = 0;
        for (Car car : carsResult) {
            int carDistance = car.getDistance();
            if (carDistance > maxDistance) {
                maxDistance = carDistance;
            }
        }

        return maxDistance;
    }

    private List<Car> decisionWinners(int maxDistance) {
        List<Car> carsResult = carRepository.findAll();
        List<Car> winners = new ArrayList<>();
        for (Car car : carsResult) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }

    private void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : " + winners.getFirst().getName());
        if (winners.size() > 1) {
            for (int i = 1; i < winners.size(); i++) {
                System.out.print(", " + winners.get(i).getName());
            }
        }
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;
import racingcar.validator.Validator;
import racingcar.validator.impl.NameValidator;
import racingcar.validator.impl.NumberValidator;

public class Racing {
    CarRepository carRepository;
    Validator nameValidator;
    Validator numberValidator;

    public Racing() {
        this.carRepository = new CarRepositoryImpl();
        this.nameValidator = new NameValidator();
        this.numberValidator = new NumberValidator();
    }

    public void race() {
        inputRacingCar();

        int number = inputFrequency();
        printExecution(number);

        int maxDistance = getMaxDistance();
        List<Car> winners = decisionWinners(maxDistance);

        printWinners(winners);

        Console.close();
    }

    private void inputRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();

        carNameInput = carNameInput.replaceAll(" ", "");
        List<String> carNames = List.of(carNameInput.split(","));
        nameValidator.validate(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        carRepository.saveAll(cars);
    }

    private int inputFrequency() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();
        numberValidator.validate(numberInput);

        return Integer.parseInt(numberInput);
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

    private int getMaxDistance() {
        List<Car> carsResult = carRepository.findAll();

        int maxDistance = carsResult.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(0);

        return maxDistance;
    }

    private List<Car> decisionWinners(int maxDistance) {
        List<Car> carsResult = carRepository.findAll();
        List<Car> winners = carsResult.stream()
                .filter((car) -> car.getDistance() == maxDistance)
                .toList();

        return winners;
    }

    private void printWinners(List<Car> winners) {
        String[] winnerArr = winners.stream()
                .map(Car::getName)
                .toArray(String[]::new);

        String winnersStr = String.join(", ", winnerArr);
        System.out.print("최종 우승자 : " + winnersStr);
    }
}

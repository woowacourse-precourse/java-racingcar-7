package racingcar;

import racingcar.validators.CarInputValidator;
import racingcar.validators.RoundInputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        String carInput = view.getCarInput();

        CarInputValidator carInputValidator = new CarInputValidator();
        carInputValidator.validate(carInput);

        String roundInput = view.getRoundInput();

        RoundInputValidator roundInputValidator = new RoundInputValidator();
        roundInputValidator.validate(roundInput);

        List<String> carNames = Arrays.asList(carInput.split(","));
        List<Car> cars = carNames.stream().map(Car::new).toList();

        System.out.println("\n실행 결과");
        for (int i = 0; i < Integer.parseInt(roundInput); i++) {
            for (Car car : cars) {
                car.makeMove(Randomizer.getRandomValue());
            }
            cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getMoves())));
            System.out.println();
        }

        int highestMove = cars.stream().mapToInt(Car::getMoves).max().getAsInt();

        List<Car> winners = cars.stream().filter(car -> car.getMoves() == highestMove).toList();

        String result = winners.stream().map(Car::getName).collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + result);
    }
}

package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

public class Game {

    private Output output = new Output();
    private Input input = new Input();
    private Cars cars;

    public void run() {
        output.printNameInputPrompt();
        String inputNames = input.readNames();

        List<String> names = Arrays.stream(inputNames.split(","))
                .map(String::strip)
                .toList();
        saveCars(names);

        output.printCountInputPrompt();
        int count = input.readCount();

        output.printResultPrompt();
        while (count-- > 0) {
            proceedRound();
            output.printNewLine();
        }

        List<String> winners = findWinners();
        output.printWinnersPrompt(winners);
    }

    private void saveCars(List<String> names) {
        List<Car> carList = names.stream()
                .map(Car::new)
                .toList();
        cars = new Cars(carList);
    }

    private void proceedRound() {
        cars.getCars()
            .stream()
            .forEach(
                car -> {
                    int condition = Randoms.pickNumberInRange(0, 9);
                    car.move(condition);
                    output.printCarStatus(car.getName(), car.getDistance());
                }
            );
    }

    private List<String> findWinners() {
        List<Car> carList = cars.getCars();
        int maxDistance = carList.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .get();
        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }
}

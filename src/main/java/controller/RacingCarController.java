package controller;

import model.Car;
import model.Race;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    public void run(){
        try {
            String carNames = InputView.getCarNames();
            List<Car> cars = splitCarNames(carNames);

            int attempts = InputView.getAttempts();
            Race race = new Race(cars);
            race.proceedRace(attempts);

            List<Car> winners = race.getWinners();
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        }


    private List<Car> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

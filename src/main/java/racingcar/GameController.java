package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    private final List<String> carNames;
    private final int rounds;
    private final List<Car> carsList;

    GameController(String validInput, String inputrounds) {
        this.carNames = Arrays.asList(validInput.split(","));
        this.rounds = Integer.parseInt(inputrounds);
        this.carsList = initGame();
    }

    //make cars
    private List<Car> initGame() {
        List<Car> cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void moveCars() {
        for (Car car : carsList) {
            car.move();
        }
    }

    private void printEachRep() {
        for (Car car : carsList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
    }

    private void printWinners() {
        List<Car> winners = getWinners();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new)));
    }

    private List<Car> getWinners() {
        int maxPosition = carsList.stream().mapToInt(Car::getLocation).max().getAsInt();
        List<Car> winners = new ArrayList<>();
        for (Car car : carsList) {
            if (car.getLocation() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void playGame() {
        System.out.println("실행 결과");

        for (int i = 0; i < rounds; i++) {
            moveCars();
            printEachRep();
            System.out.println('\n');
        }
        printWinners();
    }
}

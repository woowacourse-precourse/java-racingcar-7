package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        List<Car> carList = inputHandler.getCarName();
        RaceTrack raceTrack = new RaceTrack(carList);
        int attemptNumber = inputHandler.getAttemtNumber();

        for(int i = 0; i < attemptNumber; i ++) {
            for(Car car : carList) {
                car.move();
            }
            for(Car car : carList) {
                car.displayPosition();
            }
            System.out.println();
        }

        List<Car> winnerList = raceTrack.getWinner();
        String result = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}

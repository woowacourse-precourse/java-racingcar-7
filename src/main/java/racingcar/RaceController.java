package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {
    RaceTrack raceTrack;
    List<Car> carList;
    public RaceController(RaceTrack raceTrack, List<Car> carList) {
        this.raceTrack = raceTrack;
        this.carList = carList;
    }

    public void run(int attemptNumber) {
        for(int i = 0; i < attemptNumber; i ++) {
            moveCars();
            displayCarsCurrentPosition();
        }
    }

    public void moveCars() {
        for(Car car : carList) {
            car.move();
        }
    }

    public void displayCarsCurrentPosition() {
        for(Car car : carList) {
            car.displayPosition();
        }
        System.out.println();
    }

    public void printWinnerList() {
        List<Car> winnerList = raceTrack.getWinner();
        String result = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}

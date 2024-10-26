package racingcar;

import java.util.List;

public class Game {

    public static void start(Cars cars, int rounds){
        OutputManager.printStartMessage();
        race(cars, rounds);
        winner(cars);
    }

    private static void race(Cars cars, int rounds){
        int round = 1;

        while (round <= rounds){
            cars.moveCars();
            cars.currentStatus();
            System.out.println();
            round++;
        }
    }
    
    private static void winner(Cars cars) {
        List<Car> winners = cars.checkWinner();
        OutputManager.printWinner(winners);
    }

}

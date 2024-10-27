package racingcar.game;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.io.InputManager;
import racingcar.io.OutputManager;
import racingcar.name.Names;

public class Game {

    public static void run(){
        try {
            String input = InputManager.readInput();
            Names names = new Names(input);
            Cars cars = new Cars(names);

            int rounds = InputManager.readGameRound();

            Game.start(cars, rounds);
        } finally {
            InputManager.close();
        }
    }

    public static void start(Cars cars, int rounds){
        OutputManager.printStartMessage();
        race(cars, rounds);
        printWinner(cars);
    }

    private static void race(Cars cars, int rounds){

        for (int round = 0; round < rounds; round++){
            cars.moveCars();
            cars.printCurrentStatus();
            printNextLine();
        }

    }
    
    private static void printWinner(Cars cars) {
        List<Car> winners = cars.getWinner();
        OutputManager.printWinner(winners);
    }

    private static void printNextLine(){
        System.out.println();
    }
}

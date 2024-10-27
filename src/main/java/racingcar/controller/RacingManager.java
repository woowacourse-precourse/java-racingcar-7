package racingcar.controller;

import java.util.*;
import racingcar.global.io.*;
import racingcar.global.util.RandomMaker;
import racingcar.model.*;
import racingcar.view.*;

public class RacingManager {

    public static Cars cars;

    public static void run(){
        cars = Input.readCarName();

        System.out.println(InputMessages.TRY_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        int tryNum = scanner.nextInt();

        System.out.println(OutputMessages.EXECUTION_OUTPUT_MESSAGE);
        for(int i=0;i<tryNum;i++){
            for (Car car : cars.getCars()) {
                carMoveOrNot(car);
                Output.printResult(car);
            }
            System.out.println();
        }
        Output.printWinner(calWinner());
    }

    private static void carMoveOrNot(Car car){
        int random = RandomMaker.getRandomValue();
        if(random >= Condition.ADVANCE_CONDITION){
            car.addMove();
            if(cars.getMaxMove() < car.getMove()){
                cars.setMaxMove(car.getMove());
            }
        }
    }

    private static List<Car> calWinner(){
        List<Car> winners = new ArrayList<>();

        for (Car car : cars.getCars()) {
            if (car.getMove() >= cars.getMaxMove()){
                winners.add(car);
            }
        }

        return winners;
    }
}

package racingcar.view;

import racingcar.global.io.Condition;
import racingcar.global.io.OutputMessages;
import racingcar.model.Car;
import java.util.*;

public class Output {
    public static void printResult(Car car){
        System.out.print(car.getName()+" : ");
        for(int i=0;i< car.getMove();i++){
            System.out.print(Condition.MOVE_SYMBOL);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners){
        System.out.print(OutputMessages.FINAL_WINNER_OUTPUT_MESSAGE);
        System.out.print(" : ");

        StringJoiner joiner = new StringJoiner(", ");
        for (Car winner : winners) {
            joiner.add(winner.getName());
        }
        System.out.print(joiner.toString());
    }
}

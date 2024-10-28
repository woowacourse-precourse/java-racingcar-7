package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<Car> cars = InputHandler.getUserInput();
            int moves = InputHandler.getMoveCount();

            for (int i = 0; i < moves; i++) {
                CarController.moveCarsByRandomValue(cars);
                Print.carMovement(cars);
            }
            Print.winner(cars);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        } finally {
            Console.close();
        }
    }
}
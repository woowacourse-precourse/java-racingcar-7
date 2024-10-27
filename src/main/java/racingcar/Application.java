package racingcar;

import racingcar.dto.CarNamesInputHandler;
import racingcar.dto.GameRoundInputHandler;
import racingcar.message.Message;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Car Names
        CarNamesInputHandler carNamesInputHandler = new CarNamesInputHandler();
        carNamesInputHandler.getUserResponse();
        List<String> carNames = carNamesInputHandler.validateUserResponse();
        // Game Round
        GameRoundInputHandler gameRoundInputHandler = new GameRoundInputHandler();
        gameRoundInputHandler.getUserResponse();
        int gameRound = gameRoundInputHandler.validateUserResponse();

        List<RacingCar> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
        RacingCars racingCars = new RacingCars(cars);

        System.out.println(Message.EXECUTION_MESSAGE);
        for(int i = 0; i < gameRound; i++) {
            racingCars.moveCars();
            System.out.println(racingCars.toString());
        }

        System.out.print(Message.WINNER_MESSAGE);
        System.out.println(racingCars.getWinners());

    }

}

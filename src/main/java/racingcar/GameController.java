package racingcar;

import java.util.Map;

public class GameController {
    public void run() {
        InputCars inputCars = new InputCars();
        Map<String, Integer> carValues = inputCars.receiveCars();

        InputNumber inputNumber = new InputNumber();
        int number = inputNumber.tryNumber();

        PlayGames playGames = new PlayGames();
        carValues = playGames.repetitionGames(carValues, number);

        PrintWinner printWinner = new PrintWinner();
        printWinner.winnerPrint(carValues);
    }
}

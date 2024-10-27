package racingcar.view;

import racingcar.model.Vehicle;

import java.util.List;

import static racingcar.global.constant.GameMessage.*;

public class OutputView {
    public void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputGameRoundMessage() {
        System.out.println(INPUT_GAME_ROUND_MESSAGE);
    }

    public void printGameRoundResult(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            String result = String.format("%s : %s", vehicle.getName(), vehicle.showMovement());
            System.out.println(result);
        }
        System.out.println();
    }

    public void printGameWinner(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(OUTPUT_GAME_WINNER_MESSAGE + result);
    }
}

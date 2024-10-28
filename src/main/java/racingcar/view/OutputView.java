package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.constant.InputMessage.NUMBER_OF_ATTEMPTS;
import static racingcar.constant.InputMessage.START_GAME;
import static racingcar.constant.OutputMessage.FINAL_WINNERS;
import static racingcar.constant.OutputMessage.RESULT;

public class OutputView {

    public void printStartMessage(){
        System.out.println(START_GAME.getMessage());
    }

    public void printAttemptMessage(){
        System.out.println(NUMBER_OF_ATTEMPTS.getMessage());
    }

    public void printResultMessage(){
        System.out.println();
        System.out.println(RESULT.getMessage());
    }

    public void printResult(List<Car> participants) {
        for (Car participant : participants) {
            String distance = "-".repeat(participant.getDistance());
            System.out.println(participant.getCarName() + " : " + distance);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String finalWinners = String.join(", ", winners);
        System.out.println(FINAL_WINNERS.getMessage() + " : " + finalWinners);
    }
}

package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String carInput = readLine();
        int moveCountInput = Integer.parseInt(readLine());
        RacingService racingService = new RacingService(carInput, moveCountInput);

        racingService.startRaceGame();
        String[] winner = racingService.getWinner();

//        System.out.println(Arrays.toString(winner));
    }
}

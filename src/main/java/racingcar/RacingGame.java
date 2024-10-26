package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {

        outputHandler.showCarNamesInputComments();
        List<User> users = inputHandler.getCarNamesFromUser();

        outputHandler.showMoveCountInputComments();
        int moveCount = inputHandler.getMoveCountFromUser();

        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            for (User user : users) {
                int proceedScore = user.proceed();
                outputHandler.showCarProceedScore(user, proceedScore);
            }
            outputHandler.showNewLine();
        }

        List<String> winners = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (User user : users) {
            int score = user.getScore();
            if (score > max) {
                max = score;
                winners.clear();
                winners.add(user.getName());
            } else if (score == max) {
                winners.add(user.getName());
            }
        }
        outputHandler.showWinners(winners);
    }
}

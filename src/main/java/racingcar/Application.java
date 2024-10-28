package racingcar;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.text.View;

public class Application {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        viewer.InputCarNameView();

        String nameInputs = Console.readLine();
        InputHandler inputHandler = new InputHandler();
        String[] carNames = inputHandler.InputCarNames(nameInputs);

        viewer.InputAttemptCountView();

        String attemptCountInput = Console.readLine();
        int rounds = inputHandler.GetRound(attemptCountInput);

        viewer.OutputRaceResult();

        GameManager gameManager = new GameManager(carNames, rounds);
        gameManager.startRace();

    }
}

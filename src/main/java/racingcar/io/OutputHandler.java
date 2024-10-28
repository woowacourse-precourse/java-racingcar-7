package racingcar.io;

public interface OutputHandler {

    void showCarNamesPrompt();

    void showAttemptCountPrompt();

    void showRoundResultHeader();

    void showRoundResult(String result);

    void showWinners(String winners);
}

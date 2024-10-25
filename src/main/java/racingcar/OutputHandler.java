package racingcar;

public interface OutputHandler {
    void showCommentForCarNames();

    void showCommentForAttempt();

    void showCommentForResult();

    void showCarPosition(String name, String repeatHyphen);

    void showBlankLine();

    void showWinners(String winners);
}

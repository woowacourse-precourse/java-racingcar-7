package io;

import java.util.List;

public interface OutputHandler {
    void showCommentForCarNames();

    void showCommentForAttempt();

    void showCommentForResult();

    void showCarPosition(List<String> names, List<Long> positions);

    void showWinners(String winners);
}

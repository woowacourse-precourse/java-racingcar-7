package racingcar.view;

import racingcar.domain.GameRounds;

import java.util.List;

public interface OutputView {
    void printStartMessage();

    void printTryCountMessage();

    void printWinner(List<String> winnerNameList);

    void printGameRounds(GameRounds gameRounds);
}

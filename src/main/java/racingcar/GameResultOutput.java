package racingcar;

import java.util.List;

public interface GameResultOutput {
    void printRoundResult(List<GameRoundResultOutput> results);

    void printGameResult(List<String> winners);
}

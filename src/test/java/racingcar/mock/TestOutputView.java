package racingcar.mock;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.response.GameResult;
import racingcar.dto.response.Winners;
import racingcar.view.OutputView;

public class TestOutputView implements OutputView {
    private final List<String> outputs = new ArrayList<>();
    private int resultCount = 0;

    @Override
    public void displayRunResultText() {
        outputs.add("실행 결과");
    }

    @Override
    public void displayResult(GameResult result) {
        resultCount++;
        outputs.add("라운드 " + resultCount + " 결과");
    }

    @Override
    public void displayWinners(Winners winners) {
        outputs.add("최종 우승자 : " + String.join(", ", winners.getWinnerNames()));
    }
}

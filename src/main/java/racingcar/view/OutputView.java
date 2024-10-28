package racingcar.view;

import java.util.List;
import racingcar.dto.Result;

public class OutputView {
    public void inform() {
        System.out.println("실행 결과");
    }
    public void resultOfRound(List<Result.Round> result) {
        result.forEach(res -> {
            System.out.println(res.getName() + " : " + "-".repeat(res.getStep()));
        });
        System.out.println();
    }
}

package racingcar.combiner;

import java.util.List;
import racingcar.constant.GamePolicy;

public class Combiner {

    public String combineResult(List<String> result) {
        return String.join(GamePolicy.RESULT_SEPARATOR, result);
    }
}

package racingcar.service.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.LapScore;
import racingcar.service.constant.ExpressionFormat;
import racingcar.view.constant.Output;

public class LapScoreService {

    private final List<LapScore> lapScores;

    public LapScoreService(List<Car> entry) {
        lapScores = new ArrayList<>();
    }

    private LapScore createScore(Car racingCar) {
        return new LapScore(racingCar.getName(), carPosition(racingCar));
    }

    private String carPosition(Car racingCar) {
        return ExpressionFormat.POSITION_MARK.toString()
                .repeat(racingCar.getMileage().intValue());
    }
}

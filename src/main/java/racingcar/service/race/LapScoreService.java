package racingcar.service.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.LapScore;
import racingcar.service.constant.ExpressionFormat;

public class LapScoreService {

    private final List<LapScore> lapScores;

    public LapScoreService(List<Car> entry) {
        lapScores = new ArrayList<>();
        createEntryScores(entry);
    }

    private void createEntryScores(List<Car> entry) {
        for (Car racingCar : entry) {
            lapScores.add(createScore(racingCar));
        }
    }

    private LapScore createScore(Car racingCar) {
        return new LapScore(racingCar.getName(), carPosition(racingCar));
    }

    private String carPosition(Car racingCar) {
        return ExpressionFormat.POSITION_MARK.form()
                .repeat(racingCar.getMileage().intValue());
    }

    public List<LapScore> getLapScores() {
        return lapScores;
    }
}

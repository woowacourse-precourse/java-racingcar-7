package racingcar.gameplayer.game.racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.gameplayer.game.common.domain.PositiveNumber;
import racingcar.gameplayer.game.racinggame.app.dto.CarScore;
import racingcar.gameplayer.game.racinggame.app.dto.RoundResult;
import racingcar.gameplayer.game.racinggame.app.dto.GameResult;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(Names names) {
        for (Name name : names.getNames()) {
            cars.add(new Car(name));
        }
    }

    public GameResult proceedRound(PositiveNumber roundCount) {
        return GameResult.of(getResults(roundCount));
    }

    private List<RoundResult> getResults(PositiveNumber roundCount) {
        List<RoundResult> results = new ArrayList<>();
        for (int i = 0; i < roundCount.getNumber(); i++) {
            results.add(proceedOneRound());
        }
        return results;
    }

    private RoundResult proceedOneRound() {
        ArrayList<CarScore> roundResult = new ArrayList<>();
        for (Car car : cars) {
            car.move();
            roundResult.add(CarScore.of(car.getName(), car.getPosition()));
        }
        return RoundResult.of(roundResult);
    }
}

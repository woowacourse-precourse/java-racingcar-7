package racingcar.service;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Judgment;
import racingcar.model.MoveCommand;
import racingcar.model.MovementRecord;
import racingcar.model.RandomMoveStrategy;

public class RacingService {

    private final Cars cars;
    private final MoveCommand moveCommand;
    private final MovementRecord movementRecord;
    private final Judgment judgment;

    public RacingService(final List<String> carNames, final RandomMoveStrategy moveStrategy) {
        this.cars = new Cars(carNames);
        this.moveCommand = new MoveCommand(moveStrategy);
        this.movementRecord = new MovementRecord();
        this.judgment = new Judgment(movementRecord);
    }

    public void playGame(int rounds) {
        for (int i = 0; i < rounds; i++) {
            playRound();
        }
    }

    public MovementRecord getRoundRecords() {
        return movementRecord;
    }

    public List<String> getWinners() {
        return judgment.getWinners();
    }

    private void playRound() {
        moveCommand.command(cars);
        movementRecord.recordRound(cars);
    }

}

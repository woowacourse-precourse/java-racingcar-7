package racingcar.commander;

import racingcar.domain.MoveCommand;

@FunctionalInterface
public interface MovementCommander {
    MoveCommand moveCommand();
}

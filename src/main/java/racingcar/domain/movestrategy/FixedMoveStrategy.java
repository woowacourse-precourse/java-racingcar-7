package racingcar.domain.movestrategy;

import racingcar.domain.Car;

import java.util.function.IntSupplier;

import static racingcar.domain.numbergenerator.NumberGenerator.START_INCLUSIVE;
import static racingcar.domain.numbergenerator.RandomNumberGenerator.END_INCLUSIVE;
import static racingcar.exception.ExceptionMessage.*;

public class FixedMoveStrategy implements MoveStrategy {

    private final IntSupplier moveDecisionSupplier;

    public FixedMoveStrategy(IntSupplier moveDecisionSupplier) {
        this.moveDecisionSupplier = moveDecisionSupplier;
    }

    @Override
    public void move(Car car) {
        int inputNumber = moveDecisionSupplier.getAsInt();
        validateRandomNumber(inputNumber);

        if (canMove(inputNumber)) {
            car.move();
        }
    }

    private boolean canMove(int number) {
        return number >= MINIMUM_MOVE_CONDITION && number <= END_INCLUSIVE;
    }

    private void validateRandomNumber(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.formatMessage(START_INCLUSIVE, END_INCLUSIVE));
        }
    }
}

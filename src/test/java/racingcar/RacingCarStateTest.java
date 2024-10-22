package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarStateTest {

    @Test
    @DisplayName("움직이는데 성공하면 position이 1 증가한다.")
    void tryToMove() {
        // given
        MoveCondition moveCondition = new FixMoveCondition(true);
        Car car = new Car("pobi");
        RacingCarState racingCarState = new RacingCarState(car);



        // when
        int prevPosition = racingCarState.getPosition();
        racingCarState.tryToMove(moveCondition);
        int nextPosition = racingCarState.getPosition();


        // then
        assertEquals(prevPosition + 1, nextPosition);
    }

    @Test
    @DisplayName("움직이는데 실패하면 position이 그대로다.")
    void tryToMoveFail() {
        // given
        MoveCondition moveCondition = new FixMoveCondition(false);
        Car car = new Car("pobi");
        RacingCarState racingCarState = new RacingCarState(car);


        // when
        int prevPosition = racingCarState.getPosition();
        racingCarState.tryToMove(moveCondition);
        int nextPosition = racingCarState.getPosition();


        // then
        assertEquals(prevPosition, nextPosition);
    }



    public static class FixMoveCondition implements MoveCondition {

        private final boolean isMovable;

        public FixMoveCondition(boolean isMovable) {
            this.isMovable = isMovable;
        }


        @Override
        public boolean isMovable(RacingCarState racingCarState) {
            return isMovable;
        }
    }

}
package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {
    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void 랜덤값이_4미만이면_안_움직임(final int randomValue){
        //Given
        Move move = new Move();

        //When & Then
        assertFalse(move.checkMovable(randomValue));
    }

    @ParameterizedTest
    @ValueSource(ints={4,5,6})
    void 랜덤값이_4이상이면_움직임(final int randomValue){
        //Given
        Move move = new Move();

        //When & Then
        assertTrue(move.checkMovable(randomValue));
    }
}

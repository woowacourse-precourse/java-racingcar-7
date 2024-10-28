package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class RacingGameTest {


    @Test
    void 자동차의_이동(){
        //given
        List<String> nameList = Arrays.asList("pobi","woni","jun");
        RacingGame racingGame = new RacingGame(nameList);

        //when
        String moveCar = nameList.getFirst();
        racingGame.setMovement(moveCar);

        //then
        Map<String, String> curGameResult = racingGame.getCarData();
        String moveCarDistance = curGameResult.get(moveCar);
        assertEquals(moveCarDistance,"-");
    }

    @Test
    void 자동차의_승리(){
        //given
        List<String> nameList = Arrays.asList("pobi","woni","jun");
        RacingGame racingGame = new RacingGame(nameList);

        //when
        String moveCar = nameList.getLast();
        racingGame.setMovement(moveCar);

        //then
        List<String> result = racingGame.getGameWinner();
        assertNotNull(result);
        assertEquals(result.getFirst(),moveCar);
        assertNotEquals(result.size(),0);
    }
}

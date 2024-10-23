package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void 사용자_객체_생성_예외(String name){
        assertThrows(IllegalArgumentException.class, ()->new Player(name, ()-> Randoms.pickNumberInRange(0, 9)));
    }
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void 사용자_객체_생성_성공(String name){
        //when
        Player player = new Player(name, () -> Randoms.pickNumberInRange(0, 9));

        //then
        assertEquals(name, player.getPlayerName());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10})
    void move_실패(int pick){
        //given
        Player player = new Player("test", () -> pick);

        //when
        player.move();

        //then
        assertEquals(0, player.getPlace());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_성공(int pick){
        //given
        Player player = new Player("test", () -> pick);

        //when
        player.move();

        //then
        assertEquals(1, player.getPlace());
    }
}
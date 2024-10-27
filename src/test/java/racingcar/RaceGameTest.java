package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RaceGameTest {

    @Test
    @DisplayName("null에 대한 예외처리 성공")
    void setCarNamesListTest5(){
        RaceGame raceGame = new RaceGame();

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(null));
    }

    @Test
    @DisplayName("빈 문자열에 대한 예외처리 성공")
    void setCarNamesListTest3(){
        RaceGame raceGame = new RaceGame();
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(input));
    }

    @Test
    @DisplayName("공백으로 이루어진 문자열에 대한 예외처리 성공")
    void setCarNamesListTest4(){
        RaceGame raceGame = new RaceGame();
        String input = "   ";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(input));
    }

    @Test
    @DisplayName("문자열 split을 ','를 기준으로 제대로 수행됨")
    void setCarNamesListTest1(){
        RaceGame raceGame = new RaceGame();
        String input = "pobi,jun,won";
        String result = "pobijunwon";

        assertDoesNotThrow(() -> raceGame.getNamesList(input));
        String compare = String.join("",raceGame.carNamesList);

        assertEquals(result, compare);
    }

    @Test
    @DisplayName("이름 문자열 앞, 뒤에 존재하는 공백이 올바르게 제거됨")
    void setCarNamesListTest2(){
        RaceGame raceGame = new RaceGame();
        String input = "pobi , jun, won ";
        String result = "pobijunwon";

        assertDoesNotThrow(() -> raceGame.getNamesList(input));
        String compare = String.join("",raceGame.carNamesList);

        assertEquals(result, compare);
    }

    @Test
    @DisplayName("comma로 구분된 이름 중 빈 문자열이 있는 경우의 예외처리 성공")
    void setCarNamesListTest6(){
        RaceGame raceGame = new RaceGame();
        String input = "pobi,,jun";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(input));
    }

    @Test
    @DisplayName("comma로 구분된 이름 중 공백문자로 구성된 문자열이 있는 경우의 예외처리 성공")
    void setCarNamesListTest7(){
        RaceGame raceGame = new RaceGame();
        String input = "pobi, ,jun";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(input));
    }


}

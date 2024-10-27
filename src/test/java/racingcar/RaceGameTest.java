package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.math.BigInteger;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RaceGameTest {

    @Test
    @DisplayName("carNameList: null에 대한 예외처리 성공")
    void setCarNamesListTest5(){
        RaceGame raceGame = new RaceGame();

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(null));
    }

    @Test
    @DisplayName("carNameList: 빈 문자열에 대한 예외처리 성공")
    void setCarNamesListTest3(){
        RaceGame raceGame = new RaceGame();
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(input));
    }

    @Test
    @DisplayName("carNameList: 공백으로 이루어진 문자열에 대한 예외처리 성공")
    void setCarNamesListTest4(){
        RaceGame raceGame = new RaceGame();
        String input = "   ";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(input));
    }

    @Test
    @DisplayName("carNameList: 문자열 split을 ','를 기준으로 제대로 수행됨")
    void setCarNamesListTest1(){
        RaceGame raceGame = new RaceGame();
        String input = "pobi,jun,won";
        String result = "pobijunwon";

        assertDoesNotThrow(() -> raceGame.getNamesList(input));
        String compare = String.join("",raceGame.carNamesList);

        assertEquals(result, compare);
    }

    @Test
    @DisplayName("carNameList: 이름 문자열 앞, 뒤에 존재하는 공백이 올바르게 제거됨")
    void setCarNamesListTest2(){
        RaceGame raceGame = new RaceGame();
        String input = "pobi , jun, won ";
        String result = "pobijunwon";

        assertDoesNotThrow(() -> raceGame.getNamesList(input));
        String compare = String.join("",raceGame.carNamesList);

        assertEquals(result, compare);
    }

    @Test
    @DisplayName("carNameList: comma로 구분된 이름 중 빈 문자열이 있는 경우의 예외처리 성공")
    void setCarNamesListTest6(){
        RaceGame raceGame = new RaceGame();
        String input = "pobi,,jun";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(input));
    }

    @Test
    @DisplayName("carNameList: comma로 구분된 이름 중 공백문자로 구성된 문자열이 있는 경우의 예외처리 성공")
    void setCarNamesListTest7(){
        RaceGame raceGame = new RaceGame();
        String input = "pobi, ,jun";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getNamesList(input));
    }

    @Test
    @DisplayName("totalRounds: null 예외처리")
    void getTotalRoundsTest1(){
        RaceGame raceGame = new RaceGame();

        assertThrows(IllegalArgumentException.class, () -> raceGame.getTotalRounds(null));
    }

    @Test
    @DisplayName("totalRounds: 공백 예외처리")
    void getTotalRoundsTest2(){
        RaceGame raceGame = new RaceGame();
        String userInput = " ";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getTotalRounds(userInput));
    }


    @Test
    @DisplayName("totalRounds: 빈 문자 예외처리")
    void getTotalRoundsTest3(){
        RaceGame raceGame = new RaceGame();
        String userInput = "";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getTotalRounds(userInput));
    }


    @Test
    @DisplayName("totalRounds: 음수 예외처리")
    void getTotalRoundsTest4(){
        RaceGame raceGame = new RaceGame();
        String userInput = "-1";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getTotalRounds(userInput));
    }

    @Test
    @DisplayName("totalRounds: 숫자가 아닌 문자 예외처리")
    void getTotalRoundsTest5(){
        RaceGame raceGame = new RaceGame();
        String userInput = "lds";

        assertThrows(IllegalArgumentException.class, () -> raceGame.getTotalRounds(userInput));
    }

    @Test
    @DisplayName("totalRounds: 매우 큰 수가 들어올 경우")
    void getTotalRoundsTest6(){
        RaceGame raceGame = new RaceGame();
        String userInput = "1000000000000000000000";
        BigInteger a = new BigInteger("1000000000000000000000");

        assertThrows(IllegalArgumentException.class, () -> raceGame.getTotalRounds(userInput));
    }

    @Test
    @DisplayName("totalRounds: 양의 정수가 들어올 경우")
    void getTotalRoundsTest7(){
        RaceGame raceGame = new RaceGame();
        String userInput = "1234";
        int a = 1234;

        assertDoesNotThrow(() -> raceGame.getTotalRounds(userInput));
        assertEquals(raceGame.totalRounds, a);
    }
}

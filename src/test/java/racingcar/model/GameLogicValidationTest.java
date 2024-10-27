package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GameLogicValidationTest {

    @Test
    void 단일_우승자_테스트() {
        Map<String, Integer> resultMapSolo = Map.of("aa", 1, "bb", 2, "cc", 3);
        GameLogicValidation gameLogicValidation = new GameLogicValidation(resultMapSolo);
        assertEquals("cc", gameLogicValidation.findRacingWinner());
    }

    @Test
    void 다수_우승자_테스트() {
        Map<String, Integer> resultMapMany = new LinkedHashMap<>(); //hashMap 사용시 출력 순서 무작위 문제, LinkedHashMap 사용 필요
        resultMapMany.put("a", 1);
        resultMapMany.put("b", 2);
        resultMapMany.put("c", 2);
        GameLogicValidation gameLogicValidation = new GameLogicValidation(resultMapMany);
        assertEquals("b, c", gameLogicValidation.findRacingWinner());
    }

    @Test
    void 빈_결과_테스트() {
        Map<String, Integer> resultMapEmpty = Map.of();
        GameLogicValidation gameLogicValidation = new GameLogicValidation(resultMapEmpty);
        assertThrows(IllegalArgumentException.class, gameLogicValidation::findRacingWinner);
    }
}
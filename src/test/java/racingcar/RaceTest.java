package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {

    private Race race;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // 초기 자동차 이름 리스트와 함께 Race 인스턴스를 생성
        List<String> racersNames = Arrays.asList("pobi", "woni", "jun");
        race = new Race(racersNames);

        // System.out 출력을 캡처하여 테스트에 활용
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Race 클래스가 자동차 이름으로 초기화되는지 확인")
    void testRaceInitialization() {
        Map<String, Integer> carProgressMap = race.getCarProgressMap();
        assertEquals(3, carProgressMap.size());
        assertTrue(carProgressMap.containsKey("pobi"));
        assertTrue(carProgressMap.containsKey("woni"));
        assertTrue(carProgressMap.containsKey("jun"));
        assertEquals(0, carProgressMap.get("pobi"));
        assertEquals(0, carProgressMap.get("woni"));
        assertEquals(0, carProgressMap.get("jun"));
    }


    @Test
    @DisplayName("displayCarProgress() 출력 확인")
    void testDisplayCarProgress() {
        // 자동차 초기 상태를 출력
        race.displayCarProgress();

        // 예상 출력 결과 확인
        String expectedOutput = "pobi : \n" +
                "woni : \n" +
                "jun : \n";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }
}
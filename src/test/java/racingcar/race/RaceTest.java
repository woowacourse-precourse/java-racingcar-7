package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    @Test
    @DisplayName("자동차 등록 테스트")
    void registerCars() {
        //given
        Race race = new Race(List.of("pobi", "woni"));
        //when
        Map<String, Integer> allProgress = race.getRaceProgress();
        //then
        Map<String, Integer> expectedProgress = new HashMap<>();
        expectedProgress.put("pobi", 0);
        expectedProgress.put("woni", 0);
        assertEquals(expectedProgress, allProgress);
    }

    @ParameterizedTest
    @DisplayName("자동차 등록 예외 테스트")
    @NullAndEmptySource
    void registerCars_X(List<String> empty) {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Race(empty));
    }

    @Test
    @DisplayName("진행상황 업데이트 테스트")
    void updateProgress() {
        //given
        Race race = new Race(List.of("pobi", "woni"));
        //when
        race.updateProgress("pobi");
        race.updateProgress("woni");
        race.updateProgress("woni");
        //then
        Map<String, Integer> output = race.getRaceProgress();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("pobi", 1);
        expected.put("woni", 2);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("진행상황 업데이트 예외 테스트")
    void updateProgress_X() {
        //given
        Race race = new Race(List.of("pobi", "woni"));
        //when
        //then
        assertThrows(IllegalArgumentException.class,
                () -> race.updateProgress("nonRegisterName"));
    }

    @ParameterizedTest()
    @DisplayName("우승자 판별 테스트")
    @MethodSource("provideRaceData")
    void getWinners(List<String> progressUpdates, List<String> expected) {
        //given
        Race race = new Race(List.of("pobi", "woni"));

        //when
        for (String carName : progressUpdates) {
            race.updateProgress(carName);
        }

        //then
        List<String> actual = race.getWinners();
        assertEquals(expected, actual);

    }

    private static Stream<Arguments> provideRaceData() {
        return Stream.of(
                Arguments.of(List.of("pobi", "woni", "woni"), List.of("woni")),
                Arguments.of(List.of("pobi", "pobi", "woni"), List.of("pobi")),
                Arguments.of(List.of("pobi", "pobi", "woni", "woni"), List.of("pobi", "woni"))
        );
    }
}
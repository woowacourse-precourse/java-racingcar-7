package determiner;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerDeterminerTest {
    @Test
    void 우승자_판별() {
        //given
        WinnerDeterminer determiner = new WinnerDeterminer();
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        result.put("A", 3);
        result.put("B", 1);
        result.put("C", 3);
        //when
        List<String> winners = determiner.run(result);
        //then
        assertIterableEquals(List.of("A", "C"), winners);
    }

    @Test
    void 빈_데이터_전달() {
        //given
        WinnerDeterminer determiner = new WinnerDeterminer();
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            List<String> winners = determiner.run(result);
        });
    }
}
package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinnerListTest {
    @DisplayName("최종 우상자 여러명을 제대로 반환하는지 확인")
    @Test
    void testWinnerListReturnsCorrectWinners() {
        // Arrange
        ArrayList<Integer> advanceCountList = new ArrayList<>();
        advanceCountList.add(3); // car1
        advanceCountList.add(5); // car2
        advanceCountList.add(5); // car3
        String[] carsList = {"pobi","woni","jun"};
        int maxAdvanceCount = 5;

        // Act
        ArrayList<String> winners = WinnerList.winnerList(advanceCountList, carsList, maxAdvanceCount);

        // Assert
        assertEquals(2, winners.size());
        assertTrue(winners.contains("woni"));
        assertTrue(winners.contains("jun"));
    }

    @DisplayName("최종 우승자 한명을 제대로 반환하는지 확인")
    @Test
    void testWinnerListReturnsSingleWinner() {
        // Arrange
        ArrayList<Integer> advanceCountList = new ArrayList<>();
        advanceCountList.add(2); // car1
        advanceCountList.add(3); // car2
        advanceCountList.add(1); // car3
        String[] carsList = {"pobi","woni","jun"};
        int maxAdvanceCount = 3;

        ArrayList<String> winners = WinnerList.winnerList(advanceCountList, carsList, maxAdvanceCount);

        assertEquals(1, winners.size());
        assertEquals("woni", winners.get(0));
    }

}

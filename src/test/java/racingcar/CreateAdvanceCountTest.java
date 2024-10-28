package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateAdvanceCountTest {
    @DisplayName("리스트의 크기가 자동차 개수와 동일한지 확인")
    @Test
    void testCreateAdvanceListLengthEqualCarList(){
        String[] cars = {"pobi","woni","jun"};
        ArrayList<Integer> advanceCountList = CreateAdvanceCount.createAdvanceCount(cars);

        assertEquals(cars.length, advanceCountList.size(),"리스트의 크기가 자동차 개수와 동일하지 않습니다.");
    }

    @DisplayName("초기 전진 횟수가 모두 0인지 확인")
    @Test
    void testCreateAdvanceListAllZero(){
        String[] cars = {"pobi","woni","jun"};
        ArrayList<Integer> advanceCountList = CreateAdvanceCount.createAdvanceCount(cars);

        for (Integer count : advanceCountList) {
            assertEquals(0, count, "초기 전진 횟수가 0이 아닙니다.");
        }
    }

    @DisplayName("빈 자동차 목록일 경우 리스트도 비어있는지 확인")
    @Test
    public void testCreateAdvanceCountWithNoCars() {
        String[] cars = {};
        ArrayList<Integer> advanceCountList = CreateAdvanceCount.createAdvanceCount(cars);

        assertEquals(0, advanceCountList.size(), "빈 자동차 목록에 대한 리스트는 비어 있어야 합니다.");
    }
}

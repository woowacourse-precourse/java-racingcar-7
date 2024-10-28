package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgeTest {
    private final Judge judge = new Judge();

    @Test
    @DisplayName("경기 결과 판단 테스트1")
    public void testJudge1() {
        Car[] expected = {new Car("test1"), new Car("test2"), new Car("test3")};
        List<Car> result;

        //distance result is 2.
        expected[0].increaseDistance();
        expected[0].increaseDistance();

        //distance result is 3.
        expected[1].increaseDistance();
        expected[1].increaseDistance();
        expected[1].increaseDistance();

        //distance result is 2.
        expected[2].increaseDistance();
        expected[2].increaseDistance();

        result = judge.judge(List.of(expected));
        assertEquals(List.of(expected[1]), result);
    }

    @Test
    @DisplayName("경기 결과 판단 테스트2")
    public void testJudge2() {
        Car[] expected = {new Car("test3"), new Car("test4"), new Car("test5")};
        List<Car> result;

        //distance result is 2.
        expected[0].increaseDistance();
        expected[0].increaseDistance();

        //distance result is 3.
        expected[1].increaseDistance();
        expected[1].increaseDistance();
        expected[1].increaseDistance();

        //distance result is 3.
        expected[2].increaseDistance();
        expected[2].increaseDistance();
        expected[2].increaseDistance();

        result = judge.judge(List.of(expected));
        assertEquals(List.of(expected[1], expected[2]), result);
    }

    @Test
    @DisplayName("경기 결과 화면 테스트1")
    public void testShowJudgeResult1() {
        Car[] cars1 = {new Car("test1"), new Car("test2"), new Car("test3")};

        //distance result is 2.
        cars1[0].increaseDistance();
        cars1[0].increaseDistance();

        //distance result is 3.
        cars1[1].increaseDistance();
        cars1[1].increaseDistance();
        cars1[1].increaseDistance();

        //distance result is 2.
        cars1[2].increaseDistance();
        cars1[2].increaseDistance();
        cars1[2].increaseDistance();

        judge.judge(List.of(cars1));
        assertEquals("test2, test3", judge.getWinnerNames());
    }

    @Test
    @DisplayName("경기 결과 화면 테스트2")
    public void testShowJudgeResult2() {
        Car[] cars1 = {new Car("test1"), new Car("test2"), new Car("test3")};

        //distance result is 2.
        cars1[0].increaseDistance();
        cars1[0].increaseDistance();

        //distance result is 3.
        cars1[1].increaseDistance();
        cars1[1].increaseDistance();
        cars1[1].increaseDistance();

        //distance result is 1.
        cars1[2].increaseDistance();

        judge.judge(List.of(cars1));
        assertEquals("test2", judge.getWinnerNames());
    }
}

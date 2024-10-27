package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {
    private final Race race = new Race();

    @Test
    @DisplayName("자동차 입력 분리 테스트")
    public void testSeparateInputCars() {
        assertArrayEquals(new String[]{"test1", "test2", "test3"}, race.separateInputCars("test1,test2,test3"));
    }

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    public void testSetup() {
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("test1"));
        expected.add(new Car("test2"));
        expected.add(new Car("test3"));

        race.setup("test1,test2,test3");

        assertThat(race.getCarList())
                .usingElementComparatorOnFields("name")
                .containsExactlyElementsOf(expected);
    }
}

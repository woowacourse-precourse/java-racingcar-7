package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        ArrayList<Car> carArrayList = new ArrayList<>();
        carArrayList.add(pobi);
        carArrayList.add(woni);
        carArrayList.add(jun);

        race = new Race(carArrayList, 5);
    }

    @DisplayName("레이스에 참가한 차들을 반환한다.")
    @Test
    void getCarArrayList() {
        ArrayList<Car> expectedCarArrayList = new ArrayList<>();
        expectedCarArrayList.add(new Car("pobi"));
        expectedCarArrayList.add(new Car("woni"));
        expectedCarArrayList.add(new Car("jun"));

        ArrayList<Car> actualCarArrayList = race.getCarArrayList();

        assertEquals(expectedCarArrayList.size(), actualCarArrayList.size());

        for (int idx = 0; idx < expectedCarArrayList.size(); idx++) {
            assertEquals(expectedCarArrayList.get(idx).getName(), actualCarArrayList.get(idx).getName());
            assertEquals(expectedCarArrayList.get(idx).getLocation(),
                    actualCarArrayList.get(idx).getLocation());
        }
    }

    @DisplayName("레이스를 시도할 횟수를 반환한다.")
    @Test
    void getAttemptCount() {
        int expectedAttemptCount = 5;

        int actualAttemptCount = race.getAttemptCount();

        assertEquals(expectedAttemptCount, actualAttemptCount);
    }

    @DisplayName("레이스에 참가한 차들의 현재 위치를 반환한다.")
    @Test
    void getDistanceList() {
        List<Integer> expectedDistanceList = Arrays.asList(0, 0, 0);
        assertEquals(expectedDistanceList, race.getDistanceList());
    }
}

package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceRecordTest {
    @Test
    @DisplayName("RaceRecord에 자동차 리스트가 올바르게 저장되는지 확인하는 테스트")
    void raceRecordSaveTest() {
        List<String> beforeCarNames = new ArrayList<>();
        beforeCarNames.add("benz");
        beforeCarNames.add("hyd");
        beforeCarNames.add("kia");
        RaceRecord raceRecord = new RaceRecord(beforeCarNames);

        Map<Car, Integer> raceResult = raceRecord.getRaceResult();
        List<String> afterCarNames = new ArrayList<>();
        for (Car car : raceResult.keySet()) {
            afterCarNames.add(car.getName());
        }

        assertEquals(afterCarNames, beforeCarNames, "RaceRecord에 자동차 리스트가 올바르게 저장되지 않았슴니다.");
    }
}

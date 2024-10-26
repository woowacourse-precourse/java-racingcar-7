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

    @Test
    @DisplayName("자동차의 전진기록이 올바르게 저장되는 확인하는 테스트")
    void updateCarRecordTest() {
        List<String> carNames = new ArrayList<>();
        carNames.add("benz");
        carNames.add("hyd");
        carNames.add("kia");
        RaceRecord raceRecord = new RaceRecord(carNames);

        int moveCount = 1;
        Car updateCar = raceRecord.getOneCar("benz");
        raceRecord.updateCarRecord(updateCar, moveCount);

        int afterMoveCount = raceRecord.getOneCarRecord(updateCar.getName());
        assertEquals(afterMoveCount, moveCount, "raceResult가 올바르게 업데이트 되지 않았습니다.");
    }

    @Test
    @DisplayName("RaceRecord 생성시 자동차 기록이 0으로 초기화 되는지 확인하는 테스트")
    void raceRecordInitTest() {
        List<String> beforeCarNames = new ArrayList<>();
        beforeCarNames.add("benz");
        beforeCarNames.add("hyd");
        beforeCarNames.add("kia");
        RaceRecord raceRecord = new RaceRecord(beforeCarNames);

        final int INIT_VALUE = 0;
        assertEquals(raceRecord.getOneCarRecord("benz"), INIT_VALUE, "자동차 리스트가 0으로 초기화되지 않았슴니다.");
        assertEquals(raceRecord.getOneCarRecord("hyd"), INIT_VALUE, "자동차 리스트가 0으로 초기화되지 않았슴니다.");
        assertEquals(raceRecord.getOneCarRecord("hyd"), INIT_VALUE, "자동차 리스트가 0으로 초기화되지 않았슴니다.");
    }
}
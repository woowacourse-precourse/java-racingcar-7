package racingcar.record;

import java.util.List;
import java.util.Map;
import racingcar.racingcar.RacingCar;

public class RecordService {
    private static final RecordService RECORD_SERVICE = new RecordService();
    private final RecordValidator recordValidator = RecordValidator.getInstance();

    private RecordService() {

    }

    public static RecordService getInstance() {
        return RECORD_SERVICE;
    }

    public String raceStart(String tryTimes, List<RacingCar> racingCarList) {
        recordValidator.numberCheck(tryTimes);
        int intTryTimes = Integer.parseInt(tryTimes);
        recordValidator.validTryTimeCheck(intTryTimes);
        Record record = new Record();
        settingRecord(record, racingCarList);

        for (int i = 1; i <= intTryTimes; i++) {
            recordOneTry(record, racingCarList);
        }

        return record.getTrace().toString();
    }

    private void recordOneTry(Record record, List<RacingCar> racingCarList) {
        Map<String, Integer> latestPosition = record.getLatestPosition();
        StringBuilder trace = record.getTrace();

        for (RacingCar car : racingCarList) {
            int i = latestPosition.get(car.getName()) + car.run();
            latestPosition.replace(car.getName(), i);
            trace.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(i))
                    .append("\n");
        }
        trace.append("\n");
    }

    private void settingRecord(Record record, List<RacingCar> racingCarList) {
        Map<String, Integer> latestPosition = record.getLatestPosition();
        for (RacingCar c : racingCarList) {
            latestPosition.put(c.getName(), 0);
        }
    }

    private void findWinner(Record record){
        record.getLatestPosition()
                .entrySet()
                .so
    }
}

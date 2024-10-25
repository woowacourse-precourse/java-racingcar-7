package racingcar.record;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racingcar.racingcar.RacingCar;

public class RecordService {
    private static final RecordService RECORD_SERVICE = new RecordService();
    private final RecordValidator recordValidator = RecordValidator.getInstance();

    private RecordService() {

    }

    public static RecordService getInstance() {
        return RECORD_SERVICE;
    }

    public int raceSetting(String tryTimes) {
        recordValidator.numberCheck(tryTimes);
        int intTryTimes = Integer.parseInt(tryTimes);
        recordValidator.validTryTimeCheck(intTryTimes);
        return intTryTimes;
    }

    public String raceStart(List<RacingCar> racingCarList, int intTryTimes) {
        Record record = new Record();
        settingRecord(racingCarList, record);

        for (int i = 1; i <= intTryTimes; i++) {
            recordOneTry(racingCarList, record);
        }

        record.getTrace()
                .append("최종 우승자 : ")
                .append(findWinner(record));

        return record.getTrace()
                .toString();
    }

    private void recordOneTry(List<RacingCar> racingCarList, Record record) {
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

    private void settingRecord(List<RacingCar> racingCarList, Record record) {
        Map<String, Integer> latestPosition = record.getLatestPosition();
        for (RacingCar c : racingCarList) {
            latestPosition.put(c.getName(), 0);
        }
        record.getTrace()
                .append("실행 결과")
                .append("\n");
    }

    private String findWinner(Record record) {
        int max = record.getLatestPosition()
                .values()
                .stream()
                .max(Integer::compareTo)
                .get();

        return record.getLatestPosition()
                .entrySet()
                .stream()
                .filter(it -> it.getValue() == max)
                .map(Entry::getKey)
                .collect(Collectors.joining(", "));
    }
}

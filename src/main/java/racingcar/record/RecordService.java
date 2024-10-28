package racingcar.record;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racingcar.constant.Integers;
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
        recordValidator.blankCheck(tryTimes);
        recordValidator.numberCheck(tryTimes);
        int intTryTimes = Integer.parseInt(tryTimes);
        recordValidator.validTryTimeCheck(intTryTimes);
        return intTryTimes;
    }

    public Record raceStart(List<RacingCar> racingCarList, int intTryTimes) {
        Record record = new Record();
        settingRecord(racingCarList, record);

        for (int i = 1; i <= intTryTimes; i++) {
            recordOneTry(record);
        }
        return record;
    }

    /**
     * 각 레이싱카에게 한 번씩의 전진할 기회를 줌.
     *
     * @param record 세팅된 기록지.
     */
    private void recordOneTry(Record record) {
        Map<String, Integer> latestPosition = record.getLatestPosition();
        StringBuilder trace = record.getTrace();

        for (String carName : latestPosition.keySet()) {
            int i = latestPosition.get(carName) + run();
            latestPosition.replace(carName, i);
            trace.append(carName)
                    .append(" : ")
                    .append("-".repeat(i))
                    .append("\n");
        }
        trace.append("\n");
    }

    /**
     * 레이싱 카에 전진을 확인해 기록.
     *
     * @return 전진했을 경우 1, 전진하지 못했을 경우 0 을 반환한다.
     */
    private int run() {
        int canGo = Randoms.pickNumberInRange(0, 9);
        if (canGo >= Integers.GO_MORE_THAN_THIS.getNumber()) {
            return 1;
        }
        return 0;
    }

    /**
     * 명단과 기록지를 받아서 명단에 있는 이름을 기록하고 첫 위치를 적음.
     *
     * @param racingCarList : 레이싱 카 명단
     * @param record        : 기록지
     */
    private void settingRecord(List<RacingCar> racingCarList, Record record) {
        if (record.getLatestPosition().isEmpty()) {
            Map<String, Integer> latestPosition = record.getLatestPosition();
            racingCarList.forEach(it -> {
                latestPosition.put(it.getName(), 0);
            });
        }
        if (record.getTrace().isEmpty()) {
            record.getTrace()
                    .append("실행 결과")
                    .append("\n");
        }
    }

    /**
     * 가장 높은 점수를 파악 후 그 점수와 같은 차 기록.
     *
     * @param record 기록된 기록지.
     * @return 최종 우승자 명단을 마저 기록 후 return.
     */
    public String findWinner(Record record) {
        int max = record.getLatestPosition()
                .values()
                .stream()
                .max(Integer::compareTo)
                .get();

        String finalWinners = record.getLatestPosition()
                .entrySet()
                .stream()
                .filter(it -> it.getValue() == max)
                .map(Entry::getKey)
                .collect(Collectors.joining(", "));

        return record.getTrace()
                .append("최종 우승자 : ")
                .append(finalWinners)
                .toString();
    }
}

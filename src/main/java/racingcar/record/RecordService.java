package racingcar.record;

public class RecordService {
    private static final RecordService RECORD_SERVICE = new RecordService();
    private final RecordValidator recordValidator = RecordValidator.getInstance();
    private RecordService(){

    }

    public static RecordService getInstance() {
        return RECORD_SERVICE;
    }
    public void raceStart(String tryTimes){
        recordValidator.numberCheck(tryTimes);
        int intTryTimes = Integer.parseInt(tryTimes);
        recordValidator.validTryTimeCheck(intTryTimes);
    }
}

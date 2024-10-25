package custom.service;

import java.util.List;

public class RacingCarService {
    private final CarNameParser carNameParser;
    private final GetAttemptCount getAttemptCount;

    public RacingCarService() {
        this.carNameParser = new CarNameParser();
        this.getAttemptCount = new GetAttemptCount();
    }

    public void run(String input) {
        List<String> carList = carNameParser.run(input);
        int AttemptCount = getAttemptCount.run(input);
    }
}
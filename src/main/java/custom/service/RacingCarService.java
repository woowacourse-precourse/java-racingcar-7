package custom.service;

import java.util.List;

public class RacingCarService {
    private final CarNameParser carNameParser;

    public RacingCarService() {
        this.carNameParser = new CarNameParser();
    }

    public void run(String input) {
        List<String> carList = carNameParser.run(input);

    }
}
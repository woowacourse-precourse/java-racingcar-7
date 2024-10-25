package racingcar.controller;

import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;
import racingcar.service.RacingService;

public class RacingController {

    private static final String DELIMITERS = ",";
    private final RacingService racingService = new RacingService();

    public RacingResponse racing(RacingRequest request){
        String[] carName = parseCarName(request.carNames());
        int attemptCount = request.attemptCount();

        return racingService.racing(carName, attemptCount);
    }

    public String[] parseCarName(String carNames){
        String[] split = carNames.split(DELIMITERS);
        for (String str : split) {
            if(str.length() >= 6){
                throw new IllegalArgumentException("너무 김");
            }
        }

        return split;
    }
}

package service;

import input.ValidatedInputData;
import policy.RacingPolicy;
import repository.Repository;

public class RacingCarServiceImpl implements RacingService {
    private final ValidatedInputData validatedInputData;
    private final RacingPolicy racingPolicy;
    private final Repository repository;

    public RacingCarServiceImpl(ValidatedInputData validatedInputData, RacingPolicy racingPolicy,
                                Repository repository) {
        this.validatedInputData = validatedInputData;
        this.racingPolicy = racingPolicy;
        this.repository = repository;
    }

    @Override
    public String racingStart() {
        return null;
    }
}

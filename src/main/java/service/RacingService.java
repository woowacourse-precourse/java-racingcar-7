package service;

import policy.RacingPolicy;
import repository.Repository;

public interface RacingService {
    String racingStart();
    Repository getRepository();
    RacingPolicy getRacingPolicy();
}

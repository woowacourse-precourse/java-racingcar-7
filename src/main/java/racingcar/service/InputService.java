package racingcar.service;

import java.util.List;
import racingcar.dto.RacingCar;

public interface InputService {
    public String[] inputRacingUsersAndSplit();
    public int inputMoveCount();
    public List<RacingCar> splitUsersAndReturnList(String[] inputStrData);
}

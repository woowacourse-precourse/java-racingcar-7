package racingcar.Service;

import racingcar.DTO.RaceInfoDTO;
import racingcar.DTO.RaceResultDTO;
import racingcar.Domain.CarInfo;
import racingcar.Domain.RaceResultEvaluator;
import racingcar.Domain.RandomNumber;
import racingcar.Factory.DomainFactory;

public class RaceProcessService {
    private final DomainFactory domainFactory;

    private CarInfo carInfo;
    private Integer trialCount;
    private RaceInfoDTO raceInfoDTO;
    private RaceResultEvaluator raceResultEvaluator;
    private RandomNumber randomNumber;

    public RaceProcessService(DomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }

    public void readyRace(RaceInfoDTO raceInfoDTO) {
        this.raceInfoDTO = raceInfoDTO;

        carInfo = domainFactory.createCarInfo(raceInfoDTO.getCarNames());
        randomNumber = domainFactory.createRandomNumber();
        raceResultEvaluator = domainFactory.createRaceResultEvaluator();

        trialCount = raceInfoDTO.getTrialCount();

        startRace();
    }

    public void startRace() {
        while (trialCount > 0) {
            for (String carName : raceInfoDTO.getCarNames()) {
                Integer number = randomNumber.pickNumber();
                carInfo.moveForward(carName, number);
            }
            trialCount--;
        }
    }
}

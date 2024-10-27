package racingcar.Service;

import racingcar.DTO.RaceInfoDTO;
import racingcar.Domain.CarInfo;
import racingcar.Domain.RaceResultEvaluator;
import racingcar.Domain.RandomNumber;
import racingcar.Factory.DomainFactory;

public class RaceProcessService {
    private final DomainFactory domainFactory;

    public RaceProcessService(DomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }

    public void startRace(RaceInfoDTO raceInfoDTO) {
        CarInfo carInfo = domainFactory.createCarInfo();
        RaceResultEvaluator raceResultEvaluator = domainFactory.createRaceResultEvaluator();
        RandomNumber randomNumber = domainFactory.createRandomNumber();

        // TODO - 각 도메인부터 개발 후 이곳에서 결합
    }
}

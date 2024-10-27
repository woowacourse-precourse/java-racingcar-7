package racingcar.Service;

import racingcar.Controller.RaceViewController;
import racingcar.DTO.RaceFinalWinnerDTO;
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
    private RaceViewController raceViewController;
    private RandomNumber randomNumber;

    public RaceProcessService(DomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }

    public void readyRace(RaceInfoDTO raceInfoDTO, RaceViewController raceViewController) {
        this.raceInfoDTO = raceInfoDTO;
        this.raceViewController = raceViewController;

        carInfo = domainFactory.createCarInfo(raceInfoDTO.getCarNames());
        randomNumber = domainFactory.createRandomNumber();
        raceResultEvaluator = domainFactory.createRaceResultEvaluator();

        trialCount = raceInfoDTO.getTrialCount();

        startRace();
    }

    public void startRace() {
        RaceResultDTO raceResultDTO = new RaceResultDTO(carInfo.exportCarList());

        raceViewController.printRaceResult();

        while (trialCount > 0) {
            for (String carName : raceInfoDTO.getCarNames()) {
                Integer number = randomNumber.pickNumber();
                carInfo.moveForward(carName, number);
            }
            trialCount--;
            raceResultDTO.updateResults(carInfo.exportCarList());
            raceViewController.gatherRaceResult(raceResultDTO);
        }

        endRace(raceResultDTO);
    }

    public void endRace(RaceResultDTO raceResultDTO) {
        raceResultEvaluator.evaluateFinalWinners(raceResultDTO);
        RaceFinalWinnerDTO raceFinalWinnerDTO = new RaceFinalWinnerDTO(raceResultEvaluator.getWinners());

        raceViewController.printFinalWinners(raceFinalWinnerDTO);
    }
}

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
    private RaceInfoDTO raceInfoDTO;
    private RaceViewController raceViewController;
    private RandomNumber randomNumber;
    private Integer trialCount;

    public RaceProcessService(DomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }

    public void readyRace(RaceInfoDTO raceInfoDTO, RaceViewController raceViewController) {
        this.raceInfoDTO = raceInfoDTO;
        this.raceViewController = raceViewController;
        this.carInfo = domainFactory.createCarInfo(raceInfoDTO.getCarNames());
        this.randomNumber = domainFactory.createRandomNumber();
        this.trialCount = raceInfoDTO.getTrialCount();

        startRace();
    }

    private void startRace() {
        RaceResultDTO raceResultDTO = new RaceResultDTO(carInfo.exportCarList());
        raceViewController.printRaceResult();

        while (trialCount-- > 0) {
            stratSingleRound(raceResultDTO);
        }

        endRace(raceResultDTO);
    }

    private void stratSingleRound(RaceResultDTO raceResultDTO) {
        for (String carName : raceInfoDTO.getCarNames()) {
            Integer number = randomNumber.pickNumber();
            carInfo.moveForward(carName, number);
        }

        raceResultDTO.updateResults(carInfo.exportCarList());
        raceViewController.gatherRaceResult(raceResultDTO);
    }

    private void endRace(RaceResultDTO raceResultDTO) {
        RaceResultEvaluator evaluator = domainFactory.createRaceResultEvaluator();
        evaluator.evaluateFinalWinners(raceResultDTO);
        RaceFinalWinnerDTO finalWinnerDTO = new RaceFinalWinnerDTO(evaluator.getWinners());

        raceViewController.printFinalWinners(finalWinnerDTO);
    }
}

package racingcar.service;

import static racingcar.constant.RacingCarStatic.MAX_NUM_IN_RANDOM_RANGE;
import static racingcar.constant.RacingCarStatic.MIN_NUM_IN_RANDOM_RANGE;
import static racingcar.constant.RacingCarStatic.RACE_CONDITION;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import racingcar.entity.RacingCar;
import racingcar.repository.RacingCarRepositoryImpl;
import racingcar.util.RacingCarValidator;
import racingcar.util.StringProcessor;
import racingcar.view.OutputView;

public class RacingCarService {

    private final RacingCarRepositoryImpl racingCarRepository;
    private static final StringProcessor stringProcessor = new StringProcessor();
    private static final RacingCarValidator racingCarValidator = new RacingCarValidator();

    public RacingCarService(RacingCarRepositoryImpl racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    public RacingCar create(String carName) {
        return new RacingCar(carName);
    }

    public List<String> processingInputToList(String input) {

        List<String> carNames = new ArrayList<>();

        if (stringProcessor.hasMultipleCarNames(input)) {
            carNames.addAll(stringProcessor.splitCarNames(input));
        } else {
            carNames.add(input);
        }

        return carNames;
    }

    public void checkCarNamesValid(List<String> carNames) {
        for (String carName : carNames) {
            racingCarValidator.validateCarName(carName);
        }
    }

    public void saveAll(List<String> carNames) {
        for (String carName : carNames) {
            RacingCar racingCar = create(carName);
            racingCarRepository.save(racingCar);
        }
    }

    public BigInteger checkRaceCount(String inputRaceCount) {

        //FIXME: 한 번에 하나의 일만? => 변환도?
        racingCarValidator.validateRaceCount(inputRaceCount);

        return new BigInteger(inputRaceCount);
    }

    //FIXME: 메서드 명 모호함 + 나눌 필요? (depth 때문에?)
    public void startRacing(BigInteger raceCount, OutputView outputView) {

        List<RacingCar> racingCars = racingCarRepository.findAll();

        outputView.printTrackingStartMsg();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(raceCount) < 0; i = i.add(BigInteger.ONE)) {
            racing(racingCars, outputView);
        }
    }

    public void racing(List<RacingCar> racingCars, OutputView outputView) {

        Map<String, String> raceTracker = new HashMap<>();

        for (RacingCar racingCar : racingCars) {
            tryMove(racingCar);
            raceTracker.put(racingCar.getName(), racingCar.getFormattedDistance());
        }

        outputView.printCurrentRaceProcess(raceTracker);
    }

    private void tryMove(RacingCar racingCar) {

        int randomNum = Randoms.pickNumberInRange(MIN_NUM_IN_RANDOM_RANGE, MAX_NUM_IN_RANDOM_RANGE);

        if (randomNum >= RACE_CONDITION) {
            racingCar.move();
        }
    }

    public List<String> getFinalWinners() {

        List<String> winners = new ArrayList<>();
        List<RacingCar> racingCars = racingCarRepository.findAll();
        BigInteger maxDistance = BigInteger.ZERO;

        //TODO : 리팩토링 필요
        for (RacingCar racingCar : racingCars) {
            BigInteger distance = racingCar.getDistance();
            if (maxDistance.compareTo(distance) == 0) {
                winners.add(racingCar.getName());
            } else if (maxDistance.compareTo(distance) < 0) {
                winners = new ArrayList<>(List.of(racingCar.getName()));
                maxDistance = distance;
            }
        }

        return winners;
    }

    //FIXME : just for test??
    public Optional<RacingCar> getByName(String name) {
        return racingCarRepository.findByName(name);
    }
}

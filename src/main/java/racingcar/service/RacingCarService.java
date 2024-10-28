package racingcar.service;

import static racingcar.constant.RacingCarStatic.CAR_NAME_SEPARATOR;
import static racingcar.constant.RacingCarStatic.MAX_NUM_IN_RANDOM_RANGE;
import static racingcar.constant.RacingCarStatic.MIN_NUM_IN_RANDOM_RANGE;
import static racingcar.constant.RacingCarStatic.RACE_CONDITION;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import racingcar.entity.RacingCar;
import racingcar.repository.RacingCarRepositoryImpl;
import racingcar.util.RacingCarValidator;

public class RacingCarService {

    private final RacingCarRepositoryImpl racingCarRepository;
    private static final RacingCarValidator racingCarValidator = new RacingCarValidator();

    public RacingCarService(RacingCarRepositoryImpl racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    private void create(String carName) {
        RacingCar racingCar = new RacingCar(carName);
        racingCarRepository.save(racingCar);
    }

    public List<String> processingCarNames(String input) {
        if (hasMultipleCarNames(input)) {
            return splitCarNames(input);
        }
        return List.of(input);
    }

    private boolean hasMultipleCarNames(String input) {
        return input.contains(CAR_NAME_SEPARATOR);
    }

    private List<String> splitCarNames(String input) {
        String[] names = input.split(CAR_NAME_SEPARATOR);
        return new ArrayList<>(Arrays.asList(names));
    }

    public void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            racingCarValidator.validateCarName(carName);
        }
    }

    public void createAll(List<String> carNames) {
        for (String carName : carNames) {
            create(carName);
        }
    }

    public void validateRaceCount(String inputRaceCount) {
        racingCarValidator.validateRaceCount(inputRaceCount);
    }

    public Map<String, String>[] startRacingAndTracking(BigInteger raceCount) {

        List<RacingCar> racingCars = racingCarRepository.findAll();

        Map<String, String>[] raceResults = new HashMap[raceCount.intValue()];

        for (BigInteger i = BigInteger.ZERO; i.compareTo(raceCount) < 0; i = i.add(BigInteger.ONE)) {
            racing(racingCars);
            raceResults[i.intValue()] = tracking(racingCars);
        }

        return raceResults;
    }

    private void racing(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            tryMove(racingCar);
        }
    }

    private Map<String, String> tracking(List<RacingCar> racingCars) {
        Map<String, String> raceTracker = new HashMap<>();
        for (RacingCar racingCar : racingCars) {
            raceTracker.put(racingCar.getName(), racingCar.getFormattedDistance());
        }
        return raceTracker;
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

    public Optional<RacingCar> getByName(String name) {
        return racingCarRepository.findByName(name);
    }
}

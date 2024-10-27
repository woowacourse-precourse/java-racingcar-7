package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {
private static final int MINIMUM_CAR_COUNT = 2;
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        validateDuplicateRacingCarNames(racingCars);
        validateMinimumCarCount(racingCars);
        this.racingCars = racingCars;
    }

    private void validateDuplicateRacingCarNames(List<RacingCar> racingCars) {
        Set<String> racingCarNames = racingCars.stream()
                .map(RacingCar::getRacingCarName)
                .collect(Collectors.toSet());

        if (racingCarNames.size() != racingCars.size()) {
            throw new IllegalArgumentException("자동차 이름을 중복으로 사용할 수 없습니다.");
        }
    }

    private void validateMinimumCarCount(List<RacingCar> racingCars) {
        if (racingCars.size() < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 경주를 위해서는 최소 2대 이상의 자동차를 만들어야 합니다.");
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void moveAll(final RandomGenerator randomGenerator){
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomGenerator.generateRandom());
        }
    }

    public List<String> findRacingWinners(){
        RacingCar maxDistanceCar = findMaxDistanceCar();
        return findSameDistanceList(maxDistanceCar);
    }

    private RacingCar findMaxDistanceCar() {
        return racingCars.stream()
                .max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

    private List<String> findSameDistanceList(RacingCar maxDistanceCar) {
        return racingCars.stream()
                .filter(maxDistanceCar::isSameLocation)
                .map(RacingCar::getRacingCarName)
                .collect(Collectors.toList());
    }
}

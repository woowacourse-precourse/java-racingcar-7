package racingcar.service;

import racingcar.dto.RacingRoundResult;

import java.util.*;

import static racingcar.constant.Constants.RACING_CAR_DEFAULT_POSITION;
import static racingcar.constant.Constants.RACING_CAR_MIN_MOVABLE_NUMBER;

public class PlayArguments {

    private final List<String> carNames;
    private final int tryCount;
    private final List<Integer> randomNumbers;
    private final List<RacingRoundResult> racingRoundResults;
    private final List<String> expectedWinnersNames;

    public PlayArguments(
            List<String> carNames,
            int tryCount,
            List<Integer> randomNumbers,
            List<RacingRoundResult> racingRoundResults,
            List<String> expectedWinnersNames) {
        this.carNames = carNames;
        this.tryCount = tryCount;
        this.randomNumbers = randomNumbers;
        this.racingRoundResults = racingRoundResults;
        this.expectedWinnersNames = expectedWinnersNames;
    }

    public PlayArguments(
            List<String> carNames,
            int tryCount,
            List<Integer> randomNumbers) {
        this.carNames = carNames;
        this.tryCount = tryCount;
        this.randomNumbers = randomNumbers;
        this.racingRoundResults = calculateRacingRoundResults(randomNumbers, tryCount, carNames);
        this.expectedWinnersNames = calculateWinners(randomNumbers, tryCount, carNames);
    }

    private List<RacingRoundResult> calculateRacingRoundResults(
            List<Integer> randomNumbers,
            int tryCount,
            List<String> carNames) {

        List<RacingRoundResult> racingRoundResults = new LinkedList<>();

        // 각 자동차의 위치를 저장하는 리스트
        // 기본 위치로 초기화한다
        List<Integer> positions = new ArrayList<>(Collections.nCopies(carNames.size(), RACING_CAR_DEFAULT_POSITION));

        // 시도 횟수만큼 레이싱 라운드 결과를 계산한다.
        for (int i = 0; i < tryCount; i++) {
            racingRoundResults.add(calculateRacingRoundResult(i, randomNumbers, carNames, positions));
        }

        return racingRoundResults;
    }

    private RacingRoundResult calculateRacingRoundResult(
            int round,
            List<Integer> randomNumbers,
            List<String> carNames,
            List<Integer> positions) {

        LinkedHashMap<String, Integer> carNameAndPosition = new LinkedHashMap<>();
        for (int j = 0; j < carNames.size(); j++) {
            if (randomNumbers.get(round * carNames.size() + j) >= RACING_CAR_MIN_MOVABLE_NUMBER) {
                positions.set(j, positions.get(j) + 1);
            }
            carNameAndPosition.put(carNames.get(j), positions.get(j));
        }
        return new RacingRoundResult(carNameAndPosition);
    }

    private List<String> calculateWinners(
            List<Integer> randomNumbers,
            int tryCount,
            List<String> carNames) {

        List<RacingRoundResult> racingRoundResults = calculateRacingRoundResults(randomNumbers, tryCount, carNames);

        // 마지막 라운드의 결과를 가져온다.
        LinkedHashMap<String, Integer> lastRoundResult = racingRoundResults.get(tryCount - 1).value();

        // 마지막 라운드의 결과 중 가장 큰 값을 찾는다.
        int maxPosition = lastRoundResult.values().stream().max(Integer::compareTo).orElseThrow();

        // 가장 큰 값을 가진 자동차의 이름들을 반환한다.
        return lastRoundResult.keySet().stream()
                .filter(key -> lastRoundResult.get(key) == maxPosition)
                .toList();
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public List<RacingRoundResult> getRacingRoundResults() {
        return racingRoundResults;
    }

    public List<String> getExpectedWinnersNames() {
        return expectedWinnersNames;
    }

    @Override
    public String toString() {
        return "PlayArguments{" +
                "carNames=" + carNames +
                ", tryCount=" + tryCount +
                ", randomNumbers=" + randomNumbers +
                ", racingRoundResults=" + racingRoundResults +
                ", expectedWinnersNames=" + expectedWinnersNames +
                '}';
    }
}

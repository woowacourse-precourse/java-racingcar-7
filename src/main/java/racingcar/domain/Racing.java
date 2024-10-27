package racingcar.domain;

import racingcar.view.OutputWriter;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Racing {

    private final Validator validator;
    private final OutputWriter outputWriter;

    public Racing(Validator validator, OutputWriter outputWriter) {
        this.validator = validator;
        this.outputWriter = outputWriter;
    }

    public Map<String, Integer> splitCarNamesByComma(String racingCars) {
        List<String> racingCarNamesList = Arrays.stream(racingCars.split(","))
                .map(String::trim)
                .toList();

        for (String racingCarNames : racingCarNamesList) {
            validator.validateWhitespaceOrEmptyInCarNames(racingCarNames);
            validator.validateCarNameLength(racingCarNames);
        }
        validator.validateDuplicateRacingCarNames(racingCarNamesList);

        Map<String, Integer> racingCarNames = new HashMap<>();

        for (String racingCarName : racingCarNamesList) {
            racingCarNames.put(racingCarName, 0);
        }

        return racingCarNames;
    }


    public void executeRace(Map<String, Integer> racingCars, int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            generateRandomValue(racingCars);
        }
    }

    private void generateRandomValue(Map<String, Integer> racingCars) {
        for (String name : racingCars.keySet()) {
            int randomValue = pickNumberInRange(0, 10);
            outputWriter.getRaceResults(name, randomValue);

            if (randomValue >= 4) {
                racingCars.put(name, racingCars.get(name) + randomValue);
            }
        }
    }

    public Set<String> determineWinners(Map<String, Integer> racingCars) {
        int maxScore = 0;
        Set<String> WinnerName = new HashSet<>();

        for (Map.Entry<String, Integer> entry : racingCars.entrySet()) {
            if (entry.getValue() >= maxScore) {
                maxScore = entry.getValue();
                WinnerName.add(entry.getKey());
            }
        }

        validator.checkHasWinners(maxScore, WinnerName);

        return WinnerName;
    }
}

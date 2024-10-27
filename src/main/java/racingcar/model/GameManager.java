package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.constant.ErrorMessage;

public class GameManager {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String MOVEMENT_DISPLAY_CHARACTER = "-";
    private static final int RANDOM_START_NUMBER_FOR_MOVE_FORWARD = 0;
    private static final int RANDOM_END_NUMBER_FOR_MOVE_FORWARD = 9;

    private final List<Car> racers;

    private GameManager(List<Car> racers) {
        this.racers = racers;
    }

    private static void splitAndAddRacer(final List<Car> racers, final String input) {
        Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .forEach(carName -> {
                    racers.add(Car.from(carName));
                });
    }

    private static void validateRacerNotDuplicated(final List<Car> racers) {
        long distinctRacersCount = racers.stream().distinct().count();
        if (distinctRacersCount != racers.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.getMessage());
        }
    }

    public static GameManager from(final String input) {
        List<Car> racers = new ArrayList<>();
        splitAndAddRacer(racers, input);
        validateRacerNotDuplicated(racers);

        return new GameManager(racers);
    }

    public int generateRandomNumberForMoveForward() {
        return Randoms.pickNumberInRange(
                RANDOM_START_NUMBER_FOR_MOVE_FORWARD,
                RANDOM_END_NUMBER_FOR_MOVE_FORWARD
        );
    }

    public Map<Car, String> getCurrentMovementStates(GameStatus gameStatus) {
        Map<Car, String> currentMovementStates = new LinkedHashMap<>();

        gameStatus.getRacersMovement().forEach((racer, moved) -> {
            currentMovementStates.put(racer, MOVEMENT_DISPLAY_CHARACTER.repeat(moved));
        });

        return Collections.unmodifiableMap(currentMovementStates);
    }

    public List<Car> findWinners(GameStatus gameStatus) {
        int maximumMovement = gameStatus.getMaximumMovement();

        return gameStatus.getRacersMovement().entrySet().stream()
                .filter(movement -> movement.getValue() == maximumMovement)
                .map(Entry::getKey)
                .toList();
    }

    public List<Car> getRacers() {
        return Collections.unmodifiableList(racers);
    }
}
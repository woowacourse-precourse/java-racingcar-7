package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ExceptionMessage;
import racingcar.constant.GamePolicy;
import racingcar.constant.Message;
import racingcar.entity.RacingCar;

public class RacingCarModel {

    private final List<RacingCar> racingCars;

    public RacingCarModel() {
        racingCars = new ArrayList<>();
    }

    public void add(String name) {
        validateDuplicateCarName(name);
        racingCars.add(new RacingCar(name));
    }

    public int size() {
        return racingCars.size();
    }

    public void forwardAction(List<Integer> randoms) {
        validateRandomsSize(randoms);

        for (int i = 0; i < randoms.size(); i++) {
            if (randoms.get(i) >= GamePolicy.FORWARD_CONDITION_NUMBER) {
                racingCars.get(i).increaseDistance();
            }
        }
    }

    public void appendRunResult(StringBuilder sb) {
        racingCars.forEach(
                racingCar -> appendResult(sb, racingCar)
        );
    }

    private void appendResult(StringBuilder sb, RacingCar racingCar) {
        if (!sb.isEmpty()) {
            sb.append(Message.NEW_LINE);
        }
        sb.append(racingCar.getName())
                .append(Message.RUN_RESULT_SEPARATOR);
        for (int i = 0; i < racingCar.getDistance(); i++) {
            sb.append(Message.RUN_RESULT_DISTANCE);
        }
    }

    public List<String> getWinner() {
        int max = racingCars.stream()
                .mapToInt(RacingCar::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.RACING_CAR_DISTANCE_ERROR));

        List<String> winners = racingCars.stream()
                .filter(racingCar -> racingCar.getDistance() == max)
                .map(RacingCar::getName)
                .toList();

        return winners;
    }

    private void validateDuplicateCarName(String name) {
        String trimName = name.trim();
        boolean existDuplicateCarName = racingCars.stream()
                .anyMatch(racingCar -> racingCar.getName().equals(trimName));
        if (existDuplicateCarName) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_DUPLICATE);
        }
    }

    private void validateRandomsSize(List<Integer> randoms) {
        if (randoms.size() != racingCars.size()) {
            throw new IllegalArgumentException(ExceptionMessage.RANDOMS_SIZE_INVALID);
        }
    }
}
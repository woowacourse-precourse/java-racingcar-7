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

    // 저장된 RacingCar 확인용 메서드
    public void checkSavedCars() {
        System.out.println(Message.CHECK_SAVED_CARS_MESSAGE);
        racingCars.forEach(
                racingCar -> System.out.println(
                        "차 이름 : " + racingCar.getName() + ", 앞으로 나아간 거리 : " + racingCar.getDistance())
        );
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
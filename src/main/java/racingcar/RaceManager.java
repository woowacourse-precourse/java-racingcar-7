package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private static final int MOVE_THRESHOLD = 3;
    private final OutputProcesser outputProcesser;

    public RaceManager(OutputProcesser outputProcesser) {
        this.outputProcesser = outputProcesser;
    }

    /*
    랜덤 수 추출해서 입력받은 실행 횟수만큼 경주 실행
     */
    public void startRace(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            cars.forEach(car -> {
                if (canMove()) {
                    car.addDistance();
                }
            });
            outputProcesser.printRaceResult(cars);
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > MOVE_THRESHOLD;
    }

    /*
    우승자 판단
     */
    public String getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }
}

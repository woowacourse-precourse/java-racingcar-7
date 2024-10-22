package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameDirector {
    private final int count;
    private final CarManager manager = new CarManager();

    public GameDirector(String carNames,String count) {
        manager.add(carNames);
        this.count = Integer.parseInt(count);
    }

    public void run() {
        List<Car> carList = manager.getList();
        for (int i = 0; i < count; i++) {
            for (Car car : carList) {
                int moveNum = Randoms.pickNumberInRange(0, 9);
                car.move(moveNum);
            }
        }
    }
}

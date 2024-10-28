package racingcar.model;

import java.util.List;
// tryCount를 Race에 주입한 이유는 tryCount가 라운드의 실행 횟수이기 때문에 Race를 통해서 실행 횟수에 대한 관리가 필요하다고 생각했음.
public class Race {

    private final Cars cars;
    private final TryCount tryCount;

    public Race(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }
    // 레이스 안의 라운드 진행, 레이스에 참여한 각각의 차를 움직인다.
    public void round() {
        for (Car car : cars.getCars()) {
            car.move();
        }
    }

    public int getTryCount() {
        return tryCount.getCount();
    }

    public List<Car> getPlayers() {
        return cars.getCars();
    }

    public Winners createWinner() {
        return Winners.from(cars);
    }
}

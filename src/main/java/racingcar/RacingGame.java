package racingcar;

import java.util.List;
import java.util.stream.Collectors;

class RacingGame {
    private List<Car> cars;
    private int round = 0;

    public RacingGame(List<String> names) {
        // stream은 names를 차례로 처리 -> "name1", "name2" ...
        // map은 Car 객체로 변환 -> Car("name1"), Car("name2") ...
        // collect는 List로 변환 -> [Car("name1"), Car("name2"), ...]
        // 최종적으로 this.cars에 리스트로 된 객체 Car들을 저장
        this.cars = names.stream().map(Car::new).toList();
    }

    public void playNextRound() {
        round += 1;
        for (Car car : cars) {
            car.move();
        }
    }
    
    public List<Car> getCars() {
        return cars;
    }

    public RoundStatus getRoundStatus() {
        List<CarStatus> carStatusList = cars.stream()
                .map(it -> new CarStatus(
                        it.getName(),
                        it.getPosition(),
                        round))
                .toList();
        return new RoundStatus(round, carStatusList);
    }

    public String finalResult() {
        int maxPosition = 0;
        String winner = "";
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
                winner = car.getName();
            } else if (car.getPosition() != 0 && maxPosition == car.getPosition()) {
                winner += ", " + car.getName();
            }
        }
        return winner;
    }
}

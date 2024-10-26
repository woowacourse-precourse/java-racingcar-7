package racingcar;

import java.util.List;
import java.util.stream.Collectors;

class RacingGame {
    private List<Car> cars;

    public RacingGame(List<String> names) {
        // stream은 names를 차례로 처리 -> "name1", "name2" ...
        // map은 Car 객체로 변환 -> Car("name1"), Car("name2") ...
        // collect는 List로 변환 -> [Car("name1"), Car("name2"), ...]
        // 최종적으로 this.cars에 리스트로 된 객체 Car들을 저장
        this.cars = names.stream().map(String::trim).map(Car::new).collect(Collectors.toList());
    }

    public void play() {
        moveCar();
        showResult();
    }

    private void moveCar() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void showResult() {
        for (Car car : cars) {
            car.showPosition();
        }
    }
    
    public void finalResult() {
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
        System.out.println("최종 우승자 : " + winner);
    }
}

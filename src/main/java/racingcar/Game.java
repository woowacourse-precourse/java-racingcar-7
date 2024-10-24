package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // Car 클래스가 생성한 객체를 담는 리스트 'cars'
    private List<Car> cars;

    // 리스트를 인자로 받은 후, 인자들 모두를 Car 객체 리스트로 변환
    public Game(List<String> carList) {
        cars = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            cars.add(new Car(carList.get(i)));
        }
    }

    // 게임을 n번 반복하는 메서드
    public void play(int n) {

    }

    // 게임 한 라운드 진행
    private void round() {

    }

    // 우승자 결정 및 우승자 출력
    private void winner() {

    }

}

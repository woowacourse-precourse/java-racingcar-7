package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // Car 클래스가 생성한 객체를 담는 리스트 'cars'
    private final List<Car> cars;

    // 리스트를 인자로 받은 후, 인자들 모두를 Car 객체 리스트로 변환
    public Game(List<String> carList) {
        cars = new ArrayList<>();

        for (String s : carList) {
            cars.add(new Car(s));
        }
    }

    // 게임을 n번 반복 후, 우승자를 출력하는 메서드
    public void play(int n) {
        for (int i = 0; i < n; i++) {
            round();
        }
        printWinner();
    }

    // 게임 한 라운드 진행
    private void round() {
        for (Car car : cars) {
            car.move();
            System.out.print(car.getName() + " : ");
            car.printScore();
        }
        System.out.println();
    }

    // 최고 점수 산정
    private int getMaxScore() {
        int maxScore = 0;

        for (Car car : cars) {
            if (car.getScore() > maxScore) {
                maxScore = car.getScore(); // 최고 점수 갱신
            }
        }
        return maxScore;
    }

    // 우승자 출력
    private void printWinner() {
        int maxScore = getMaxScore();
        List<String> winners = new ArrayList<>();

        // 우승자를 winners에 입력
        for (Car car : cars) {
            if (car.getScore() == maxScore) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        // 우승자가 1명일 때
        if (winners.size() == 1) {
            System.out.println(winners.getFirst());
        }

        // 우승자가 2명 이상일 때
        else {
            for (int i = 0; i < winners.size() - 1; i++) {
                System.out.print(winners.get(i) + ", ");
            }
            // 마지막 우승자 출력 (콤마 없이 출력하기 위해 분리)
            System.out.println(winners.getLast());
        }
    }
}

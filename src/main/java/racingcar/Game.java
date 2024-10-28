package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars; // 자동차 객체들을 저장하는 리스트
    private int attempts; // 경주 시도 횟수

    // 생성자: 자동차 이름 배열과 시도 횟수를 받아서 초기화
    public Game(String[] carNames, int attempts) {
        this.cars = new ArrayList<>(); // 자동차 리스트 초기화
        for (String name : carNames) {
            cars.add(new Car(name)); // 자동차 이름마다 Car 객체 생성
        }
        this.attempts = attempts; // 시도 횟수 저장
    }

    // 경주를 시작하는 메소드
    public void startRace() {
        for (int i = 0; i < attempts; i++) { // 시도 횟수만큼 반복
            for (Car car : cars) {
                int randomValue = getRandomNumber(); // 무작위 값 생성
                car.move(randomValue); // 각 자동차에 무작위 값 주입하여 전진 여부 결정
                System.out.println(car.getName() + " : " + car.getPosition()); // 각 자동차의 이름과 위치 출력
            }
            System.out.println(); // 차수별 결과를 구분하기 위한 줄바꿈
        }
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }


    // 가장 멀리 간 자동차의 위치를 반환하는 메소드
    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPositionValue() > maxPosition) { // 현재까지의 최대 위치보다 큰 경우 업데이트
                maxPosition = car.getPositionValue();
            }
        }
        return maxPosition; // 최대 위치 반환
    }

    // 경주가 끝난 후 우승자를 출력하는 메소드
    public void printWinners() {
        int maxPosition = getMaxPosition(); // 가장 멀리 간 자동차의 위치를 구함
        List<String> winners = new ArrayList<>(); // 우승자들을 저장할 리스트
        for (Car car : cars) {
            if (car.getPositionValue() == maxPosition) { // 우승자 조건: 최대 위치와 같은 자동차들
                winners.add(car.getName()); // 우승자 리스트에 이름 추가
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners)); // 우승자 출력, 여러 명일 경우 쉼표로 구분
    }
}

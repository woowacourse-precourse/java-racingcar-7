package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 처리 및 유효성 검사
        InputHandler inputHandler = new InputHandler();
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = inputHandler.getCarNames();
        inputHandler.validCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int moveCnt = inputHandler.getMoveCnt();
        inputHandler.validMoveCnt(moveCnt);

        // 자동차 객체 생성
        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();

        // 경주 시작
        Race race = new Race(cars, moveCnt);
        race.startRace();

        // 우승자 결정
        List<String> winners = race.getWinners();
        System.out.println("최종 우승자 : " + winners);
    }
}
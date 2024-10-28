package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    // 게임 시작 설정 및 라운드 결과 출력
    private final List<racingcar.Car> cars;
    private final int rounds;   // 시도 횟수

    public Game() {
        this.cars = getCarName();
        this.rounds = inputRoundCount();
    }

    private List<racingcar.Car> getCarName() {
        // 자동차 이름 받기
        System.out.print("자동차의 이름을 입력하세요(,로 구분): ");
        String input = Console.readLine();
        String[] names = input.split(",");
        List<racingcar.Car> cars = new ArrayList<>();

        // 입력 받은 이름 공백 제거하여 생성
        for (String name : names) {
            cars.add(new racingcar.Car(name.trim()));
        }

        return cars;
    }

    private int inputRoundCount() {
        // 시도 횟수 받기, 숫자만 받기
        System.out.println("시도할 횟수는 몇 회인가요");
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    void startGame() {
        // 게임 진행 결과 출력 + 게임시작
        for (int i = 0; i < rounds; i++) {
            getPoint();
            racingcar.GameResult.printRoundResult(cars);  // 라운드 결과 출력
        }
        racingcar.GameResult.printWinners(cars);   // 최종 우승자 출력
    }

    void getPoint() {
        // 자동차 이동 여부확인
        for (racingcar.Car car : cars) {
            car.point();    // 랜던 값으로 이동
        }
    }
}
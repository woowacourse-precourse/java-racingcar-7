package racingcar;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        ConsoleInputOutput io = new ConsoleInputOutput();

        // 1. 자동차 이름 입력받기
        List<String> carNames = io.getCarNames();

        // 2. 게임 실행 횟수 입력받기
        int iteration = io.getIteration();

        // 3. 경주 게임 초기화 및 실행
        RaceGame raceGame = new RaceGame(carNames);
        System.out.println("실행 결과");

        while (iteration-- > 0) {
            raceGame.playRound();
            raceGame.printStatus();
        }

        // 4. 최종 우승자 출력
        raceGame.printWinners();
    }
}

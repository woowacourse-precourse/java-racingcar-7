package racingcar;

import java.util.List;

public class Output {
    public void printInit() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    
    public void printRacingResult(List<Car> cars) {
        System.out.println("실행 결과");
        for(Car car : cars) {
           car.printMoveResult();
        }
        System.out.println();
    }

    public void printWinner(List<String> winner) { // 하면 끗
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
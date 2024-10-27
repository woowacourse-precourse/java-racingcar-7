package view;

import java.util.List;
import model.Car;

public class OutputView {

    public static void printGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printExecutionResult() {
        System.out.println("실행결과");
    }

    public void printWarningMessage() {
        System.out.println("경고: 시도 횟수가 너무 많아 중간 결과를 생략합니다.");
    }

    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println((getPositionStatus(car)));
        }
        printEmptyLine();
    }

    public void printFinalWinner(List<String> finalWinners) {
        String result = String.join(", ", finalWinners);
        System.out.println("최종 우승자 : " + result);
    }

    // 자동차의 상태를 문자열로 변환
    public static String getPositionStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }
}

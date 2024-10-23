package view;

import model.Car;

public class OutputHandler {

    public void printGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCurrentStatus(Car car) {
        String result = car.getPositionStatus();
        System.out.println(result);
    }
}

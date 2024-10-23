package racingcar.view;

public class OutView {
    // TODO: 프로그램 구현
    public void displayResult(InputData inputData) {
        
        String[] cars = inputData.getCarNames().split(",");

        System.out.println("실행 결과");
        for (int i = 0; i < inputData.getTrialNum(); i++) {
            for (String car : cars) {
                System.out.println(car + ": ");
            }
            System.out.println("\n");
        }

    }
}

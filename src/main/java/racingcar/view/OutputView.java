package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printCarNamesPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCarMove(List<String> carNames) {
        for (String carName : carNames) {
            System.out.print(carName + " : ");
            printCarMovement(carName.length());
        }
    }

    private static String repeatString(int count){
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            resultBuilder.append("-");
        }
        return resultBuilder.toString();
    }

    private static void printCarMovement(int count){
        System.out.println(repeatString(count));
    }


}

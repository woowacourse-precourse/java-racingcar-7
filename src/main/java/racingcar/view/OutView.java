package racingcar.view;

public class OutView {
    // TODO: 프로그램 구현
    public void displayResult(int[] carArr, String[] cars) {

//        System.out.println("실행 결과");
//        for (int i = 0; i < trialNum; i++) {
//            for (String car : cars) {
//                System.out.println(car + ": ");
//            }
//            System.out.println("\n");
//        }
        int i = 0;
        for (String car : cars) {
            System.out.println(car + " : " + "" + "-".repeat(Math.max(0, carArr[i++])));
        }

    }
}

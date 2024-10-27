package racingcar.view;

public class OutputView{
    public static void printResult(String result) {
        System.out.print("최종 우승자 : " + result);
    }

    public static void printForwardResult(String[] cars, int[] forwardDistance) {
        for (int index = 0; index < cars.length; index++) {
            String forwardResult = cars[index] + " : "
                    + "-".repeat(forwardDistance[index]);

            System.out.println(forwardResult);
        }
        System.out.println();
    }
}

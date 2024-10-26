package racingcar.io;

public class Output {
    private static final String RACE_RESULT = "실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public static void printMessage(String message) {
        System.out.println(message);
    }

//    public static void printResult() {
//        StringBuilder resultOutput = new StringBuilder(RACE_RESULT);
//
//    }

    public static void printWinner(String[] winnerNames) {
        StringBuilder winnersOutput = new StringBuilder(WINNER_PREFIX);
        for (int i = 0; i < winnerNames.length; i++) {
            winnersOutput.append(winnerNames[i]);
            if (i != winnerNames.length - 1) {
                winnersOutput.append(WINNER_DELIMITER);
            }
        }
        printMessage(winnersOutput.toString());

////        System.out.print(WINNER_PREFIX);
//        printMessage(WINNER_PREFIX);
//        for (int i = 0; i < winnerNames.length; i++) {
////            System.out.print(winnerNames[i]);
//            printMessage(winnerNames[i]);
//            if (i != winnerNames.length - 1) {
////                System.out.print(WINNER_DELIMITER);
//                printMessage(WINNER_DELIMITER);
//            }
//        }
    }
}

package racingcar.view;

public class OutputView {
    public static void printRoundResults(String[] carNames, int[] goCounts) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + " : " + "-".repeat(goCounts[i]));
        }
        System.out.println(); // 각 시도 결과 출력 후 한 줄 띄우기
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}

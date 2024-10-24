package utility;

import java.util.List;

public class Result {
    private static String ongoing;
    private static String winner;
    private static int idxMax = 0;

    // 진행 결과 출력
    public static void printOngoing(List<String> cars, List<Integer> currentSituation) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < currentSituation.size(); i++) {
            sb.append(cars.get(i)).append(" : ").append("-".repeat(currentSituation.get(i))).append("\n");
        }

        ongoing = sb.toString();
        System.out.println(ongoing);
    }

    // 우승자 출력
    public static void printWinner(List<String> cars, List<Integer> currentSituation) {
        StringBuilder sb = new StringBuilder(cars.getFirst());

        for (int i = 1; i < cars.size(); i++) {
            compareValue(i, sb, currentSituation, cars);
        }

        winner = "최종 우승자 : " + sb;
        System.out.println(winner);
    }

    // 값 비교
    private static void compareValue(int currentIdx, StringBuilder sb, List<Integer> currentSituation, List<String> cars) {
        String tmpCurrentCarName = cars.get(currentIdx);
        int tmpCurrentValue = currentSituation.get(currentIdx);
        int tmpMaxValue = currentSituation.get(idxMax);

        if (tmpCurrentValue > tmpMaxValue) {
            sb.setLength(0);
            sb.append(tmpCurrentCarName);
            idxMax = currentIdx;
        } else if (tmpCurrentValue == tmpMaxValue) {
            sb.append(", ").append(tmpCurrentCarName);
        }
    }

    // Test
    public static String[] test(List<String> cars, List<Integer> progress) {
        try {
            printOngoing(cars, progress);
            printWinner(cars, progress);

            return new String[]{ongoing, winner};

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error");
        }
    }

    public static void setOngoing(String ongoing) {
        Result.ongoing = ongoing;
    }

    public static void setWinner(String winner) {
        Result.winner = winner;
    }

    public static void setIdxMax(int idxMax) {
        Result.idxMax = idxMax;
    }
}

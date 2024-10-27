package util;

import java.util.List;

public class Result {
    private static int idxMax = 0;

    // 진행 결과 출력
    public static String printOngoing(List<String> car, List<Integer> process) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < process.size(); i++) {
            sb.append(car.get(i)).append(" : ").append("-".repeat(process.get(i))).append("\n");
        }

        return sb.toString();
    }

    // 우승자 출력
    public static String printWinner(List<String> car, List<Integer> process) {
        StringBuilder sb = new StringBuilder(car.getFirst());

        for (int i = 1; i < car.size(); i++) {
            compareValue(i, sb, process, car);
        }

        return "최종 우승자 : " + sb;
    }

    // 값 비교
    private static void compareValue(int currentIdx, StringBuilder sb, List<Integer> process, List<String> car) {
        String tmpCurrentCarName = car.get(currentIdx);
        int tmpCurrentValue = process.get(currentIdx);
        int tmpMaxValue = process.get(idxMax);

        if (tmpCurrentValue > tmpMaxValue) {
            sb.setLength(0);
            sb.append(tmpCurrentCarName);
            idxMax = currentIdx;
        } else if (tmpCurrentValue == tmpMaxValue) {
            sb.append(", ").append(tmpCurrentCarName);
        }
    }

    // Test
    public static String[] test(List<String> car, List<Integer> progress) {
        try {
            return new String[]{printOngoing(car, progress), printWinner(car, progress)};
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error");
        }
    }

    public static void setIdxMax(int idxMax) {
        Result.idxMax = idxMax;
    }
}

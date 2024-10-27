package racingcar.game;

public class Result {
    public static void printWinner(int[] carArr, String[] cars) {
        int max = carArr[0];

        for (int carResult : carArr) {
            if (max <= carResult) {
                max = carResult;
            }
        }
        StringBuilder win = new StringBuilder("");
        int i = 0;
        for (String car : cars) {
            if (carArr[i++] == max) {
                win.append(car);
                if (!win.isEmpty()) {
                    win.append(", ");
                }
            }
        }

        System.out.println("최종 우승자 : " + win.deleteCharAt(win.length() - 2));

    }
}

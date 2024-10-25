package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        String[] names = Console.readLine().split(",");
        int attempts = Integer.parseInt(Console.readLine());
        String[] individualCarMovements = new String[names.length];
    }

    public static void individualRandoms(String[] individualCarMovements, String[] names) { // 1회 이동 메서드
        for (int i = 0; i < names.length; i++) {
            if (Randoms.pickNumberInRange(0, 9) > 4) {
                individualCarMovements[i] += "-";
            }
        }
        for (int j = 0; j < names.length; j++) {
            System.out.println(names[j] + " : " + individualCarMovements[j]);
        }
    }


}
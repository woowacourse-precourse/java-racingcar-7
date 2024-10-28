package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Cars {

    String name;
    static String move = "";
    int tryCount;
    static int count = 0;

    public Cars(String s, int num) {
        name = s;
        tryCount = num;
    }

    public static void printMoves(List<Cars> cars) {
        for (Cars car : cars) {
            System.out.println(car.name+" : "+move);
        }
    }

    public static void moving(List<Cars> cars){
        for (Cars car : cars) {
            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
                move += "-";
                count += 1;
            }
        }
        printMoves(cars);
    }

}

package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Cars {

    String name;
    String move = "";
    int count = 0;
    static List<Cars> cars = new ArrayList<>();

    public Cars(String s) {
        name = s;
    }

    public static void makeCarslist(List<String> carsList) {
        for (String s : carsList) {
            cars.add(new Cars(s));
        }
    }

    public static void printMoves(List<Cars> cars) {
        for (Cars car : cars) {
            System.out.println(car.name + " : " + car.move);
        }
        System.out.print("\n");
    }

    public static void tryMoving(int tryCount) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < tryCount; i++) {
            moving();
        }
        printWinner();
    }

    public static void moving() {
        for (Cars car : cars) {
            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
                car.move += "-";
                car.count++;
            }
        }
        printMoves(cars);
    }

    public static void printWinner() {
        int maxCount = 0;

        for (Cars car : cars) {
            if (car.count > maxCount) {
                maxCount = car.count;
            }
        }

        System.out.print("최종 우승자 : ");
        int num = 0;

        for (Cars car : cars) {
            if (car.count == maxCount) {
                if (num > 0) {
                    System.out.print(", ");
                }
                System.out.print(car.name);
                num++;
            }
        }
    }
}

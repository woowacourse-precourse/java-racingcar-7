package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Cars {

    String name;
    static String move = "";
    static int tryCount;
    static int count = 0;
    static List<Cars> cars = new ArrayList<>();

    public Cars(String s, int num) {
        name = s;
        tryCount = num;
    }

    public static void makeCarslist(List<String> carsList){
        for (String s : carsList) {
            cars.add(new Cars(s, tryCount));
        }
    }

    public static void printMoves(List<Cars> cars) {
        for (Cars car : cars) {
            System.out.println(car.name+" : "+move);
        }
    }
    public static void tryMoving(int tryCount){
        for(int i=0; i<tryCount; i++){
            moving();
        }
    }

    public static void moving(){
        for (Cars car : cars) {
            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
                Cars.move += "-";   
                Cars.count += 1;
            }
        }
        printMoves(cars);
    }

}

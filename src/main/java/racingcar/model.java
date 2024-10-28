package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

class Car {
    String name;
    int move_cnt;

    Car(String name, int move_cnt) {
        this.name = name;
        this.move_cnt = move_cnt;
    }

    public void increaseCnt() {
        int random_num = pickNumberInRange(0, 9);
        if (random_num >= 4) {
            this.move_cnt++;
        }
    }
}

public class model {
    public static List<Car> car_list = new ArrayList<>();
    public static List<Car> winner_list = new ArrayList<>();
    public static int gameCount;
}
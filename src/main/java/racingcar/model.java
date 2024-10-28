package racingcar;

import java.util.ArrayList;
import java.util.List;

class Car {
    String name;
    int move_cnt;

    Car(String name, int move_cnt) {
        this.name = name;
        this.move_cnt = move_cnt;
    }
}

public class model {
    public static List<Car> car_list = new ArrayList<>();
    public static List<Car> winner_list = new ArrayList<>();
    public static int totalCount;
}
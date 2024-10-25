package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] nameArr = Console.readLine().split(",");
        ArrayList<Car> carArr = new ArrayList<>();
        for (int i = 0; i<nameArr.length;i++){
            Car car = new Car(nameArr[i]);
            carArr.add(car);
        }
    }
}

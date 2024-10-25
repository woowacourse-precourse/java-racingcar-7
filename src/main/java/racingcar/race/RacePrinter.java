package racingcar.race;

import java.util.List;

public class RacePrinter {
    public void print(String carName, List<Boolean> moveForwardList) {
        int repeatHyphen = (int) moveForwardList.stream().filter(val -> val).count();
        System.out.println(carName + " : " + "-".repeat(repeatHyphen));
    }
}

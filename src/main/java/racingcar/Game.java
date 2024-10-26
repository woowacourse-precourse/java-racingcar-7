package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
public class Game {
    public static void printCars(Car car){
        System.out.print(String.format("%s : ",car.carName));
        System.out.println("-".repeat(car.space));
    }
}

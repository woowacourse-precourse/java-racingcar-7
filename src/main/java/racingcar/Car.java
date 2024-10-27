package racingcar;

import java.util.ArrayList;

public class Car {
    private static String name;
    private static ArrayList<String> moveList;
    private static ArrayList<Car> carList;

    public Car(String name) {
        this.name = name;
        carList.add(this);
    }

    ArrayList<String> move(InputView inputView){
        for (int i = 0; i < inputView.inputRounds() ; i++) {
            if(RandomNumber.getRandomNum() >= 4){
                moveList.add("-");
            }
        }
        return moveList;
    }

    public static ArrayList<String> getMoveList() {
        return moveList;
    }

    public static String getName() {
        return name;
    }

    public static ArrayList<Car> getCarList() {
        return carList;
    }
}

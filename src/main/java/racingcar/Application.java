package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String inputCarName = Console.readLine();
        int inputTry = Integer.parseInt(Console.readLine());

        String[] carListName = inputCarName.split(",");

        initCarList(carListName);


    }

    private static void initCarList(String[] carListName) {
        ArrayList<Car> carList = new ArrayList<>();

        for (String carName : carListName) {
            isValidCarName(carName);
            carList.add(new Car(carName));
        }
    }

    private static void isValidCarName(String carName){
        if(carName.length() < 5){
            throw new IllegalArgumentException("차의 이름이 5글자를 넘어갑니다.");
        }
    }

}

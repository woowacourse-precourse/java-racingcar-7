package racingcar;

import java.util.*;

public class Application {
    public static List<Car> getCarList() {
        String inputString;
        String[] carNames;

        while (true) {
            boolean isCorrectInput = true;
            inputString = camp.nextstep.edu.missionutils.Console.readLine();
            carNames = inputString.split(",");

            //자동차 이름 길이 확인
            for (String carName : carNames) {
                if (carName.length() > 5) {
                    isCorrectInput = false;
                    break;
                }
            }

            //자동차 개수 확인
            if (isCorrectInput && carNames.length <= 100) {
                List<Car> carList = new ArrayList<>();
                for (String carName : carNames) {
                    carList.add(new Car(carName));
                }
                return carList;
            }
        }
    }

    public static void main(String[] args) {

    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static String inputText() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = Console.readLine();
        return text;
    }

    public static List<Car> createCarList(String text) {
        List<Car> carList = new ArrayList<>();

        for (String carName : text.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            carList.add(new Car(carName));
        }

        return carList;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String text = inputText();

        List<Car> carList = new ArrayList<>();
        carList = createCarList(text);
        
    }
}

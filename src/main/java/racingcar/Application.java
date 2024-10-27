package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readLine();
        List<Car> cars = getCars(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            int repeat = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    public static List<Car> getCars(String names){
        List<String> carNames = Arrays.asList(names.split(","));
        List<Car> cars = new ArrayList<>();
        try{
            for (String carName : carNames) {
                cars.add(new Car(carName));
            }
        } catch (IllegalArgumentException e){
            throw e;
        }
        return cars;
    }
}

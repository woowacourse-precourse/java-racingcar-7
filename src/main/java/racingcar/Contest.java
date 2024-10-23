package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Contest {
    private  ArrayList<Car> cars = new ArrayList();
    private static int gameNum = 0;

    public Contest() {//생성자
        System.out.println("경주할 자동차 이름을 입력하세요.");
    }

    public void input() {
        String inputCars = Console.readLine();
        String[] carNmaes = inputCars.trim().split(",");

        for(String name : carNmaes) {
            Car car = new Car(name);
            cars.add(car);
        }

        gameNum = Integer.valueOf(Console.readLine().trim());

    }
}
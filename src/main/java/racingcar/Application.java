package racingcar;

import java.util.LinkedList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static class Car{
        String name;
        int moveDistance;

        public Car(String name, int moveDistance) {
            this.name = name;
            this.moveDistance = moveDistance;
        }
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();

        LinkedList<Car> carList = new LinkedList<>();
        carList = parsingCarName(carNames);

    }

    public static LinkedList<Car> parsingCarName(String carNames){
        LinkedList<Car> carList = new LinkedList<>();

        for(String name : carNames.split(",")){
            carList.add(new Car(name, 0));
        }

        return carList;
    }
}

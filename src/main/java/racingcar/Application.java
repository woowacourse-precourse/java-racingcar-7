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

        System.out.println(carList);

    }

    static LinkedList<Car> parsingCarName(String carNames){
        LinkedList<Car> carList = new LinkedList<>();

        if(carNames == null || carNames.isBlank())
            throw new IllegalArgumentException();


        for(String name : carNames.split(",")){
            checkCarName(name);
            carList.add(new Car(name.trim(), 0));
        }

        return carList;
    }

    static void checkCarName(String name){
        if(name == null || name.isBlank())
            throw new IllegalArgumentException();

        if(name.length() > 5)
            throw new IllegalArgumentException();
    }
}

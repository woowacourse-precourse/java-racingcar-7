package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static class Car{
        String name;
        int moveDistance;

        public Car(String name, int moveDistance) {
            this.name = name;
            this.moveDistance = moveDistance;
        }

        public void moveOneStep(){
            this.moveDistance += 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();

        LinkedList<Car> carList = new LinkedList<>();
        carList = parsingCarName(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNum = Integer.parseInt(readLine());
        if(tryNum <= 0)
            throw new IllegalArgumentException();

        for(int i = 0; i < tryNum; i++){
            moveForward(carList);
            outPutConsole(carList);
            System.out.println();
        }

        winner(carList);
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

    static void moveForward(LinkedList<Car> carList){
        for (Car car : carList) {
            int tmpMoveDistance = Randoms.pickNumberInRange(0, 9);

            if(tmpMoveDistance >= 4){
                car.moveOneStep();
            }
        }

    }

    static void outPutConsole(LinkedList<Car> carList){
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.print(car.name + " : ");
            int distance = car.moveDistance;

            for(int i = 0; i < distance; i++){
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }

    static void winner(LinkedList<Car> carList){
        int max = Integer.MIN_VALUE;

        Queue<Car> maxCarList = new LinkedList<>();
        for (Car car : carList) {
            if(car.moveDistance == max){
                maxCarList.add(car);
            }else if(car.moveDistance > max){
                max = car.moveDistance;

                maxCarList.clear();
                maxCarList.add(car);
            }
        }

        System.out.print("최종 우승자 : ");
        while(!maxCarList.isEmpty()){
            Car pollCar = maxCarList.poll();
            System.out.print(pollCar.name);

            if(!maxCarList.isEmpty()){
                System.out.print(", ");
            }
        }
    }
}
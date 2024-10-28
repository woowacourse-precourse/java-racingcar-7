package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Game {
    int moveNumber;
    ArrayList<Car> cars;

    List<String> readCarName(){
        System.out.println("게임을 진행할 자동차들의 이름을 쉼표(,)로 구분하여 입력 해주세요.");
        List<String> carNames = new ArrayList<>();
        try{
            String readString= Console.readLine();
            String regex = "^([A-Za-z0-9][A-Za-z0-9 ]{0,4})(,[A-Za-z0-9][A-Za-z0-9 ]{0,4})*$";
            if(!Pattern.matches(regex, readString))
                throw new IllegalArgumentException();
            carNames = List.of(readString.split(","));

        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    void readMoveNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            String readString = Console.readLine();
            String regex = "^[^0]\\d*$";
            if(!Pattern.matches(regex, readString))
                throw new IllegalArgumentException();
            moveNumber = Integer.parseInt(readString);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    void createCars(List<String> carNames){
        if(carNames.isEmpty())
            throw new IllegalArgumentException();
        cars = new ArrayList<Car>();
        for(String carName : carNames)
            cars.add(new Car(carName));
    }

    void moveCars(){
        for(Car car : cars)
            car.moveCar();
    }

    void printCars() {
        for (Car car : cars)
            car.printCar();
        System.out.println();
    }

    public Game(){
        List<String> carNames = readCarName();
        createCars(carNames);
        readMoveNumber();
    }

    public String getWinner(){
        String Winner = "";
        int maxMove = -1;
        for (Car car : cars){
            if(car.move > maxMove)
                Winner = car.name;
            if(car.move == maxMove)
                Winner = String.join(", ",Winner,car.name);
        }
        return Winner;
    }

    public void run(){
        System.out.println("실행결과");
        for(int round = 0; round < moveNumber; round++){
            moveCars();
            printCars();
        }
        System.out.println("최종 우승자 : "+getWinner());
    }


}

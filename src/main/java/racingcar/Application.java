package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class Car{
    private String name;
    private int move;

    public Car(String name){
        this.name = name;
        this.move = 0;
    }
    public String getName(){
        return name;
    }
    public int getMove(){
        return move;
    }
    public void moving(){
        this.move++;
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.( 이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        List<Car> cars = createCars(carName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int moveTryCount;
        try {
            moveTryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");
        for(int i=0;i<moveTryCount;i++){
            moving(cars);
        }

        winner(cars);
    }

    public static List<Car> createCars(String carNames){
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(",",-1);

        for(String name : names){
            if(name == null || name.isBlank() || name.length() > 5){
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name));
        }

        return cars;
    }

    public static void moving(List<Car> cars){
        for(Car car : cars){
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if(randomNum >= 4){
                car.moving();
            }
            System.out.println(car.getName() + " : " + "-".repeat(car.getMove()));
        }
        System.out.println();
    }

    public static void winner(List<Car> cars){
        int maxMove = 0;
        for(Car car : cars){
            if(car.getMove() > maxMove){
                maxMove = car.getMove();
            }
        }
        List<String> winnerNames = new ArrayList<>();
        for(Car car : cars){
            if(car.getMove() == maxMove){
                winnerNames.add(car.getName());
            }
        }
        System.out.print("최종 우승자 : ");
        for(int i=0;i<winnerNames.size();i++){
            System.out.print(winnerNames.get(i));
            if(i < winnerNames.size()-1){
                System.out.print(",");
            }
        }
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/*
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
자동차 경주 실행 및 실행과정 출력(반복문)
최종우승자 판단 메서드(Winner) 작성
최종우승자 결과 출력
 */
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

    }
}

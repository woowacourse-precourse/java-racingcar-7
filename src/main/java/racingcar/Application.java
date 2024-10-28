package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/*

각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

입력된 자동차 n대를 쉼표를 기준으로 각각 분리
5자 초과,공백,null인 경우 예외 발생
자동차 이름 출력 메소드 작성

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
횟수입력(try) : 숫자만 가능, 이외에의 경우 예외 발생

전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
Randoms.pickNumberInRange(0, 9); 사용
전진하기 메서드(Move) 작성
조건문으로 전진하기 메서드(Move) 실행

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
자동차 경주 실행 및 실행과정 출력(반복문)
최종우승자 판단 메서드(Winner) 작성
최종우승자 결과 출력

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
n대의 자동차 입력 : 공백,null,이름 5자 초과 입력시 예외 발생 및 종료
횟수입력 : 숫자 이외 입력시 예외 발생 및 종료
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
        //System.out.println("시도할 횟수는 몇 회인가요?");
        //String moveTryCount = Console.readLine();

        List<Car> cars = createCars(carName);

        for(Car car : cars){
            System.out.println("car name : " + car.getName());
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

    public static void Moving(List<Car> cars){

    }

    public static void Winner(List<Car> cars){

    }
}

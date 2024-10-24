package racingcar;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

// 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
//   [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
//   [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
//   [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
//   [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
//    자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
//    우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
//    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
public class Application {

    public static Car[] getCarName(String inputCars){

        String[] splitCar=inputCars.split(",");
        Car[] cars=new Car[splitCar.length];
        for(int i=0;i<splitCar.length;i++){
            if(splitCar[i].length()>5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            cars[i]=new Car(splitCar[i],0);
        }
        return cars;

    }

    public static void move(int count,Car[] cars){
        System.out.println("실행 결과");
        for (int i=0; i<count;i++){
            for(int j=0;j<cars.length;j++){
                int randomNum=(int) (Math.random()*10);
                if(randomNum>=4){
                    cars[j].setMoveCountPlus();
                }
            }
            printByRound(cars);
        }
    }

    public static void printByRound(Car[] cars){
        for(int i=0;i<cars.length;i++){
            System.out.print(cars[i].getName()+" : ");
            for(int j=0;j<cars[i].getMoveCount();j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars=scanner.nextLine();
        Car[] cars=getCarName(inputCars);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count=scanner.nextInt();
        move(count,cars);

    }
}

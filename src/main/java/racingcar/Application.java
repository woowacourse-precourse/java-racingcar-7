package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

*/
public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawNameList = Console.readLine(); // need to validate
        String[] nameList= rawNameList.split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        String rawTryCnt = Console.readLine();
        int tryCnt = 0;

        try {
            tryCnt = Integer.parseInt(rawTryCnt);
        }
        catch(Exception e){

            throw new IllegalArgumentException("It is not number.");
        }

        List<Car> carList = new ArrayList<Car>();
        ArrayList<Car> winnerCars = new ArrayList<Car> ();

        for(String name : nameList){
            carList.add(new Car(name));
        }

        System.out.println("실행 결과");
        for(int i = 0; i < tryCnt; ++i){

            for(Car car : carList){
                car.moveForward();
            }
            System.out.print("\n");
        }

        int maxMove = carList.getFirst().moveCnt;

        for(Car car : carList){

            if(maxMove < car.moveCnt){
                maxMove = car.moveCnt;;
            }
        }

        for(Car car : carList){

            if(maxMove == car.moveCnt){
                winnerCars.add(car);
            }
        }

        String winner = "";

        for(Car car : winnerCars){
            winner = winner.concat(car.name+", ");
        }

        winner = winner.substring(0,winner.lastIndexOf(", "));

        System.out.println("최종 우승자 : " + winner);

    }
}

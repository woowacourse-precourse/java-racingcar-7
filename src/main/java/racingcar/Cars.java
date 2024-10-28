package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    /* 자동차 클래스 관리 클래스 생성 - 0
    * - 우승 자동차 결정 기능
    * - 우승 자동차 출력 기능
    * - 우승자가 여러 명일 경우, 쉼표(,)를 이용하여 구분한다.
    * 잘못된 값이 입력될 경우 IllegalArgumentException을 발생시키고 에플리케이션을 종료한다.
     */

    private List<Car> cars;

    public Cars(List<String> names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public void printCurrentPositions(){
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveDisctance()));
        }
        System.out.println();
    }

    public void printWinners(){
        int maxMoveDistance = maxMoveDistance();
        List<String> winners = findWinners(maxMoveDistance);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public int maxMoveDistance(){
        int maxMoveDistance = 0;

        for (Car car : cars) {
            if(car.getMoveDisctance() > maxMoveDistance){
                maxMoveDistance = car.getMoveDisctance();
            }
        }
        return maxMoveDistance;
    }

    public List<String> findWinners(int maxMoveDistance){
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if(car.getMoveDisctance() == maxMoveDistance){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

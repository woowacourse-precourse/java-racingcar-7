package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Car> cars = getCarNames();
        int rounds = getRounds();
        playRacingCar(cars,rounds);
    }

    // 자동차 이름 입력
    private static List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        List<Car>cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    // 시도할 횟수 입력
    private static int getRounds(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    //게임 진행
    private static void playRacingCar(List<Car> cars, int rounds){
        System.out.println("실행 결과");
        for(int i = 0 ; i < rounds ; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                car.moveCar(randomNumber);
                printCurrentPosition(cars);
            }
        }

    }

    //현재 위치 출력
    private static void printCurrentPosition(List<Car> cars){
        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            for(int j = 0 ; j < car.getPosition() ; j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    //자동차 클래스
    static class Car {
        private String name;
        private int position;

        public Car(String name){
            this.name = name;
            this.position = 0;
        }
        //무작위 값이 4 이상일 경우 전진
        public void moveCar(int randomNumber){
            if(randomNumber >= 4){
                position++;
            }
        }
        public String getName(){
            return name;
        }
        public int getPosition(){
            return position;
        }
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try{
            List<Car> cars = getCarNames();
            int rounds = getRounds();
            playRacingCar(cars,rounds);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    // 자동차 이름 입력
    private static List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        List<Car>cars = new ArrayList<>();

        for (String name : names) {
            validateCarName((name.trim()));
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    //자동차 이름 입력 유효성 검사
    private static void validateCarName(String name){
        if(name.isEmpty() || name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
        }
    }

    //입력 횟수 입력 유효성 검사
    private static void validateRound(String round){
        try{
            Integer.parseInt(round);
        }catch(Exception e){
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
        if(Integer.parseInt(round) < 1){
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    // 시도할 횟수 입력
    private static int getRounds(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        validateRound(input);

        return Integer.parseInt(input);
    }

    //게임 진행
    private static void playRacingCar(List<Car> cars, int rounds){
        System.out.println("실행 결과");
        for(int i = 0 ; i < rounds ; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                car.moveCar(randomNumber);
            }
            printCurrentPosition(cars);
        }
        getWinner(cars);
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

    //우승자 추출
    private static void getWinner(List<Car> cars){
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
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

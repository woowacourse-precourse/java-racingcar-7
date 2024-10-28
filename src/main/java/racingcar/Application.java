package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Car{
    private String name;
    private int now = 0;
    public Car(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public int getNow(){
        return this.now;
    }
    public void move(int value){
        if(value>=4){
            now++;
        }
    }
    public String printNow(){
        return name+" : "+"-".repeat(now);
    }
}
public class Application {
    private static List<Car> cars = new ArrayList<>();
    private static int count = 0;

    public static void checkNameDuplicate(List<String> names) {
        // 예외처리 : 자동차 이름이 같을 경우
        Set<String> uniqueNames = Set.copyOf(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야 합니다.");
        }
    }
    public static void checkNameLength(List<String> names){
        // 예외처리 : 자동차 이름의 길이가 5글자를 초과하는 경우
        for(String name:names){
            if(name.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    public static void addCars(List<String> names){
        for(String name: names){
            cars.add(new Car(name));
        }
    }

    public static void playTurn(){
        for(Car car:cars){
            car.move(Randoms.pickNumberInRange(0,9));
            System.out.println(car.printNow());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 1. 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(Console.readLine().split(","));
        checkNameDuplicate(carNames);
        checkNameLength(carNames);

        // 2. 시도할 횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        count = Integer.parseInt(Console.readLine());
        System.out.println("\n실행결과");

        // 3. 경주 시행
        addCars(carNames);
        while(count>0){
            playTurn();
            count--;
        }

        // 4. 우승자 출력


    }
}

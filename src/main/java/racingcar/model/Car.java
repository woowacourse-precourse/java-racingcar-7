package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private List<Character> moveTo;

    public Car(){
        this.moveTo = new ArrayList<>();
    };

    public Car(String name){
        this.name=name;
        this.moveTo = new ArrayList<>(); // 초기화
         }

    private String getName(){
        return this.name;
    }

    public List<Character> getMoveTo() {
        return this.moveTo;
    }

    // void 쉼표로 구분해서 Car 생성자 만들기
    public static List<Car> createCars(String input){
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
        return cars;
    }

    // 무작위 숫자를 통해 전진/멈춤으로 moveTo
    private static void randomMove(Car car){
        char hyphen = '-';
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) {
            car.moveTo.add(hyphen);
        }
    }

    // 시도할 횟수만큼 무작위 숫자 반복
    public static void randomMoves(List<Car> cars, int tryNumber){
        for(int i=0;i<cars.size();i++){
            for(int j=0;j<tryNumber;j++){
                randomMove(cars.get(i));
                printNow(cars);
            }
        }
        findWinner(cars);
    }

    // 출력 관련
//    private static void printNow(List<Car> cars){
//        for(Car car : cars){
//            System.out.println(car.getName()+" : "+car.getMoveTo().toString().replace("[", "").replace("]", ""));
//        }
//    }

    // 각 Car들의 moveTo 인덱스를 비교해서 우승자 return
    public static void findWinner(List<Car> cars){
        Optional<Integer> maxSize = cars.stream()
                .map(car -> car.getMoveTo().size())
                .max(Integer::compareTo);


        List<String> maxCars = cars.stream()
                .filter(car -> car.getMoveTo().size() == maxSize.orElse(0)) // 최댓값과 같은 크기 필터링
                .map(Car::getName) // Car 이름만 가져오기
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + maxCars.toString().replace("[","").replace("]",""));
    }

}

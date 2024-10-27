package racingcar;

import java.util.List;

public class Car {
    private String name;
    private Integer forward;

    public Car(String carName, int forward) {
        this.name = carName;
        this.forward = forward;
    }

    public void moveForward(){
        forward = getForward() + 1;
    }

    public void printForward(){
        System.out.print(getName() + " : ");
        for(int i=0; i<forward; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printCarName(){
        System.out.print(getName());
    }

    public void printCarNameWithComma(){
        System.out.print(", " + getName());
    }

    private String getName(){
        return name;
    }
    private Integer getForward(){
        return forward;
    }

    public static List<Car> getMaxByForward(List<Car> cars) {
        // 가장 큰 a 값을 가진 Car 객체 찾기
        int maxForward = cars.stream()
                .mapToInt(Car::getForward)
                .max() // 최대값 찾기
                .orElseThrow(() -> new IllegalArgumentException("최대값을 찾을 수 없습니다."));

        // 최대값을 가진 Car 객체들 필터링
        return cars.stream()
                .filter(car -> car.getForward() == maxForward) // 최대값과 같은 Car 객체들
                .toList(); // 결과 리스트로 변환
    }
}

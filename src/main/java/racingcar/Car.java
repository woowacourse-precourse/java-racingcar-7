package racingcar;

// 시도횟수 입력 - 5,
public class Car {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 차 객체를 생성하는 메서드
     */
    public static Car createCar(String name){
        Car car = new Car();
        car.setName(name);
        return car;
    }
}

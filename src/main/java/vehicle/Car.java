package vehicle;

import policy.RacingPolicy;

public class Car implements Vehicle{
    private final String carName;
    private Long moveForwardCount;

    public Car(String carName, Long moveForwardCount) {
        this.carName = carName;
        this.moveForwardCount = moveForwardCount;
    }
    public Car(String carName, RacingPolicy racingCarPolicy) {
        this.carName = validateNameLength(carName,racingCarPolicy);
        this.moveForwardCount = 0L;
    }


    @Override
    public String getVehicleName() {
        return this.carName;
    }

    @Override
    public Long getMoveForwardCount() {
        return this.moveForwardCount;
    }

    @Override
    public void move() {
        moveForwardCount+=1L;
    }

    public String validateNameLength(String carName, RacingPolicy racingCarPolicy){
        if(carName.length() > racingCarPolicy.getNameLengthPolicy()){
            //TODO : exceptionMessage Enum 만들어서 관리 하기.
           throw  new IllegalArgumentException("자동차 이름은 "+ racingCarPolicy.getNameLengthPolicy()+"를 넘을 수 없습니다.");
        }
        return carName;
    }



}

package racingcar.domain;

public class Car {
    
    private String carName;
    private int moveDistance;
    
    public Car(String carName) {
        this.carName = carName;
    }
    
    public String getCarName() {
        return carName;
    }
    
    public int getMoveDistance() {
        return moveDistance;
    }
    
    public void plusDistance() {
        moveDistance++;
    }
    
    // 게임의 결과를 출력하기 위한 메서드
    public String getGameCurrentStatus() {
        String result = this.carName + " : ";
        
        for (int i = 0; i < moveDistance; i++) {
            result += "-";
        }
        
        return result;
    }
}

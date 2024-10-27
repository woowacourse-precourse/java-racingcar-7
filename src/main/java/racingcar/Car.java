package racingcar;

// 시도횟수 입력 - 5,
public class Car {
    private String name;
    private int moveCount;

    /**
     * 자동차 전진 메서드
     *  - 랜덤 값이 4 이상일 경우에만 전진
     * */
    public void move(int randomNum){
        if(randomNum>=4){
            this.moveCount += 1;
        }
    }

    public Car(String name){
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}

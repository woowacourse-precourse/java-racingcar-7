package racingcar.model.Car;

public class Car implements Comparable<Car> {
    private int moveCount;
    private String name;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public Car() { //테스트 코드 용 생성자
        this.name = "";  // 기본값 설정
        this.moveCount = 0;
    }

    public Car(String name, int moveCount) { //테스트 코드 용 생성자
        this.name=name;
        this.moveCount=moveCount;
    }

    public String getRaceResult(String COLON, String MOVE_CHAR) {
        return name + COLON + MOVE_CHAR.repeat(moveCount);
    }

    public void addMove(int move) {
        moveCount+=move;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return o.moveCount-this.moveCount;
    }
}

package racingcar;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 테스트용 생성자
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(){
        if (isMovable()) position++;
    }

    private boolean isMovable() {
        return pickNumberInRange(0,9) >= 4;
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

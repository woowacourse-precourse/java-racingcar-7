package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자 입력 받기
        String carNames = Console.readLine();
        int round = Integer.parseInt(Console.readLine());

        //자동차 게임 시작
        String[] names = carNames.split(",");

    }

    // car 클래스 생성
    static class Car {
        private String name;
        private int position = 0;

        public Car(String name) {
            this.name = name;
        }

        public void move() {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                position++;
            }
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }
}

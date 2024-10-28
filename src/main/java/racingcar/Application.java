package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

class Car {
    String name;
    int move_cnt;

    Car(String name, int move_cnt) {
        this.name = name;
        this.move_cnt = move_cnt;
    }
}

public class Application {
    static Car car_list[];
    static int totalCount;

    public static void checkValid(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void saveCar(String user_input) {
        user_input += ",";
        String name = "";
        int idx = 0;
        for (int i = 0; i < user_input.length(); i++) {
            if (user_input.charAt(i) != ',') {
                name += user_input.charAt(i);
            } else {
                checkValid(user_input);

                Car new_car = new Car(name, 0);
                car_list[idx++] = new_car;
                name = "";
            }
        }

    }

    public static void inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String user_input = readLine();
        saveCar(user_input);
    }

    public static void inputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        totalCount = Integer.parseInt(readLine());
    }

    public static void main(String[] args) {
        inputCar();
        inputCount();
    }
}

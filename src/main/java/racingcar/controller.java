package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import static racingcar.model.winner_list;
import static racingcar.model.car_list;
import static racingcar.model.totalCount;
import static racingcar.view.printGame;

public class controller {
    public static void checkNumberValid(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkNameValid(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void saveCar(String user_input) {
        user_input += ",";

        String name = "";
        for (int i = 0; i < user_input.length(); i++) {
            if (user_input.charAt(i) != ',') {
                name += user_input.charAt(i);
            } else {
                checkNameValid(name);
                car_list.add(new Car(name, 0));
                name = "";
            }
        }
    }

    public static void getWinner(int score) {
        for (int i = 0; i < car_list.size(); i++) {
            Car tempCar = car_list.get(i);
            if (tempCar.move_cnt == score) {
                winner_list.add(tempCar);
            }
        }
    }

    public static int getMaxNum() {
        int maxi = 0;
        for (int i = 0; i < car_list.size(); i++) {
            Car tempCar = car_list.get(i);
            maxi = Math.max(maxi, tempCar.move_cnt);
        }
        return maxi;
    }

    public static void getRandomNum() {
        for (int i = 0; i < car_list.size(); i++) {
            Car tempCar = car_list.get(i);
            int random_num = pickNumberInRange(0, 9);
            if (random_num >= 4) {
                tempCar.move_cnt++;
            }
        }
    }

    public static void gameProgress() {
        System.out.println("실행 결과");
        for (int i = 0; i < totalCount; i++) {
            getRandomNum();
            printGame();
        }
        getWinner(getMaxNum());
    }
}

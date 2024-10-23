package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String move_cnt = Console.readLine();

        ArrayList<Car> race_result = race_start(cars, move_cnt);
        ArrayList<String> winners = getRaceWinners(race_result);
        printWinners(winners);
    }

    public static ArrayList<Car> add_cars(String cars) {
        ArrayList<Car> carList = new ArrayList<>();
        for (String car_name : cars.split(",")) {
            car_name = car_name.strip();
            validate(car_name);
            carList.add(new Car(car_name, 0));
        }
        return carList;
    }

    public static void validate(String car_name) {
        if (car_name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static ArrayList<Car> race_start(String cars, String move_cnt) {
        ArrayList<Car> carList = add_cars(cars);
        int move_time = Integer.parseInt(move_cnt);
        while (move_time-- > 0) {
            carList = move_car(carList);
            showRaceprogress(carList);
        }
        return carList;
    }

    public static ArrayList<Car> move_car(ArrayList<Car> carList) {
        for (Car car : carList) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.setDistance(car.getDistance() + 1);
            }
        }
        return carList;
    }

    public static void showRaceprogress(ArrayList<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print('-');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList<String> getRaceWinners(ArrayList<Car> carList) {
        int maxwins = 0;
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getDistance() > maxwins) {
                maxwins = car.getDistance();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getDistance() == maxwins) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static void printWinners(ArrayList<String> winners) {
        int i;
        System.out.print("최종 우승자 : ");
        for (i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.get(winners.size() - 1));
    }
}

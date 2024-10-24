package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int trial;
    public Race(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }
    public void start() {
        for (int i = 0; i < trial; i++) {
            play();
            System.out.println();
        }
        print();
    }
    private void play() {
        for (Car car : cars) {
            move(car);
            printName(car);
        }
    }
    private void move(Car car) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            String result = car.getResult();
            result += "-";
            car.setResult(result);
        }
    }
    private void printName(Car car) {
        System.out.println(car.getName() + " : " + car.getResult());
    }
    private List<String> rank() {
        cars.sort(Comparator.comparingInt(car -> car.getResult().length()));
        int maxLength = cars.get(cars.size() - 1).getResult().length();
        List<String> list = new ArrayList<>();
        for (Car car : cars) {
            if (car.getResult().length() == maxLength) {
                list.add(car.getName());
            }
        }
        return list;
    }
    private void print() {
        List<String> list = rank();
        if (list.size() == 1) {
            System.out.println("최종 우승자 : " + rank().get(0));
        }
        else {
            String winner = "최종 우승자 : ";
            for (int i=0; i< list.size() - 1; i++) {
                winner += list.get(i);
                winner += ", ";
            }
            winner += list.get(list.size() - 1);
            System.out.println(winner);
        }
    }
}
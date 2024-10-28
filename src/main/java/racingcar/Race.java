package racingcar;

import java.util.ArrayList;

public class Race {
    private Input input = new Input();
    private ArrayList<Car> cars = new ArrayList<>();

    public void run() {
        setRace();
        startRace();
        getWinner(cars);
    }

    public void setRace() {
        input.setCarNames();
        input.setRounds();

        for (String name : input.getCarNames()) {
            cars.add(new Car(name));
        }
    }

    public void startRace() {
        System.out.println("실행 결과");
        for (int i=1 ; i <= input.getRounds(); i++) {
            for (Car car: cars) {
                car.run();
                System.out.println(makeCarResult(car));
            }
        }
    }

    public void getWinner(ArrayList<Car> cars) {
        ArrayList<String> winners = new ArrayList<>();

        int maxForward = 0;
        for (Car car: cars) {
            if (car.getForward() > maxForward) {
                maxForward = car.getForward();
            }
        }

        for (Car car: cars) {
            if (car.getForward() == maxForward) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private String makeCarResult(Car car) {
        return car.getName() + " : " + "-".repeat(car.getCondition());
    }
}
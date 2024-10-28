package racingcar;

import java.util.*;

public class Controller {
    public View view;
    private List<Car> carList;

    public Controller(View view) {
        this.view = view;
        this.carList = new ArrayList<>(); // Initialize the carList here
    }

    public void addCars() {
        view.RaceStartComment();
        String name = view.getRaceCars().trim().replaceAll("\\s+", "");
        ArrayList<String> names = new ArrayList<>(Arrays.asList(name.split(",")));
        for (String i : names) {
            if(i.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 제한됩니다: " + i);
            }
            Car car = new Car(i);
            carList.add(car);
        }
    }

    public void racing() {
        view.AskCountComment();
        int count = view.getRaceCount();
        System.out.println();
        
        view.ResultComment();
        for (int i = 0; i < count; i++) {
            for (Car c : carList) {
                c.setPosition();
                view.RoundResult(c.getName(), c.getPosition());
            }
            System.out.println();
        }

        List<Car> winners = findWinners();
        view.FinalWinnerComment();
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private List<Car> findWinners() {
        int maxPosition = carList.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void processing() {
        addCars();
        racing();
    }
}

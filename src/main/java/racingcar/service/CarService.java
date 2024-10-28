package racingcar.service;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarService {
    public String[] getCarsByDelimiter(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("널이거나 비었네");
        }
        String[] cars = carNames.split(",");
        if (cars.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String name : cars) {
            System.out.println("name = " + name);
            if (name.isBlank())
                throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
            if (name.length() > 5)
                throw new IllegalArgumentException("이름의 길이가 5글자 이상입나다.");

        }
        return cars;
    }

    public int getNumber(String number) {
        if (number == null || number.isBlank())
            throw new IllegalArgumentException("널이거나 공백입니다.");
        if (number.charAt(0) == '-')
            throw new IllegalArgumentException("음수입니다.");
        try {
            int data = Integer.parseInt(number);
            if (data <= 0)
                throw new IllegalArgumentException("입력값이 0이거나 오버플로우가 발생했습니다.");
            return data;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 소수나 문자입니다.");
        }
    }

    public String getWinner(List<Car> cars) {
        int winnerPosition = cars.stream()
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition().length() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }
}

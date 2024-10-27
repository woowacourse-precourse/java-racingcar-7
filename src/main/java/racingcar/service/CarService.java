package racingcar.service;

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
}

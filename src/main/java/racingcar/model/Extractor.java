package racingcar.model;

public class Extractor {

    public Cars extractCars(String input) {
        String[] split = input.split(",");

        Cars cars = Cars.newCars();
        for (String s : split) {
            cars.addCar(Car.newCar(s.strip()));
        }

        return cars;
    }
}

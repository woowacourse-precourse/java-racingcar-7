package racingcar.service.factory;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.member.Member;

public class CarFactory {

    public List<Car> getCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();
        names.forEach(name -> {
            Member member = new Member(name);
            cars.add(Car.of(member));
        });
        return cars;
    }
}

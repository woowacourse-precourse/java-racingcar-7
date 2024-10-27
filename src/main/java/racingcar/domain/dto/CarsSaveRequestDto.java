package racingcar.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarsSaveRequestDto {

    // @Pattern(1~5글자)
    private final List<String> names;

    public CarsSaveRequestDto(List<String> carsName) {
        this.names = carsName;
    }

    public List<Car> toEntity() {
        return names.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return names;
    }
}

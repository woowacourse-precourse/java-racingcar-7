package dto;

import java.util.ArrayList;
import util.Car;

public record RacingParam(ArrayList<Car> cars, int repeatCount) {
}

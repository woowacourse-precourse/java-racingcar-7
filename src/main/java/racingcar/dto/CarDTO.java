/*
 * CarDTO
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
package racingcar.dto;

public class CarDTO {
    private final String carName;
    private final int position;

    public CarDTO(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String getState() {
        return carName + " : " + "-".repeat(Math.max(0, position));
    }
}

package racingcar.dto;

public class ViewDto {

    private String carName;
    private Integer count;

    private ViewDto(String carName, Integer count) {
        this.carName = carName;
        this.count = count;
    }

    public static ViewDto of(String carName, Integer count){
        return new ViewDto(carName,count);
    }

    public String getCarName() {
        return carName;
    }

    public Integer getCount() {
        return count;
    }
}

package racingcar.object.value;

public record Winners(CarNames winners) {

    public Winners {
        if (winners == null) {
            throw new IllegalArgumentException("null을 지정할 수 없습니다.");
        }
    }

}

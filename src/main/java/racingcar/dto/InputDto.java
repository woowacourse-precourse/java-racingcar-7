package racingcar.dto;

import java.util.List;

public class InputDto {

    public static class RequestInputDto {

        private final List<String> inputCars;
        private final int inputCnt;

        public RequestInputDto(List<String> inputCars, int inputCnt) {

            this.inputCars = inputCars;
            this.inputCnt = inputCnt;
        }

        public List<String> getInputCars() {
            return this.inputCars;
        }

        public int getInputCnt() {
            return this.inputCnt;
        }
    }
}

package racingcar.dto;

public class Result {
    public static class Round {
        private String name;
        private int step;

        public Round(String name, int step) {
            this.name = name;
            this.step = step;
        }
    }
}

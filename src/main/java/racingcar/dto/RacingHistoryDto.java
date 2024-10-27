package racingcar.dto;

public class RacingHistoryDto {
    public static class RacingHistoryOutputDto {
        private final String carName;
        private final int roundNumber;
        private final int totalMovedDistance;

        public RacingHistoryOutputDto(String carName, int roundNumber, int totalMovedDistance) {
            this.carName = carName;
            this.roundNumber = roundNumber;
            this.totalMovedDistance = totalMovedDistance;
        }

        public String getCarName() {
            return carName;
        }

        public int getRoundNumber() {
            return roundNumber;
        }

        public int getTotalMovedDistance() {
            return totalMovedDistance;
        }
    }
}

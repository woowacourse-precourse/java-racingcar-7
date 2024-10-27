package racingcar;

public class Race {
    private Car[] cars;
    private int rounds;
    
    public Race(String[] carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
    }

    private Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for(int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }
    public void start(){
        for(int i = 0;i<rounds;i++) {
            playRound();
        }
        decideWinner();
    }

    private void decideWinner() {
        String winners = getWinners();
        System.out.println("최종 우승자 : " + winners);
    }
    private String getWinners() {
        int maxPosition = getMaxPosition();
        StringBuilder winners = new StringBuilder();

        for(Car car : cars) {
            addWinnerIfMaxPosition(car, maxPosition, winners);
        }
        return winners.toString();
    }

    private void addWinnerIfMaxPosition(Car car, int maxPosition, StringBuilder winners) {
        if(car.getPosition() == maxPosition) {
            if(winners.length() > 0) {
                winners.append(", ");
            }
            winners.append(car.getName());
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for(Car car : cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private void playRound() {
        for(Car car : cars){
            car.move();
            car.printPosition();
        }
    }
}

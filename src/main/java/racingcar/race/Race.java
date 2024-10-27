package racingcar.race;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.io.page.Page;
import racingcar.io.page.SimpleTextPage;

public class Race {

    private List<? extends Vehicle> vehicles;

    private Map<Vehicle, Integer> positions;

    private int round;

    private List<Vehicle> winners;

    private Race() {}

    public Race(List<? extends Vehicle> vehicles, int round) {
        validateVehicleSize(vehicles);
        validateRound(round);

        this.vehicles = vehicles;
        this.positions = new HashMap<>();
        this.vehicles.forEach(vehicle -> this.positions.put(vehicle, 0));
        this.round = round;
        this.winners = new ArrayList<>();
    }

    private static void validateVehicleSize(List<? extends Vehicle> vehicles) {
        if (vehicles.size() < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대가 필요합니다.");
        }
        if (vehicles.size() > 10) {
            throw new IllegalArgumentException("자동차는 최대 10대까지 생성할 수 있습니다.");
        }
    }

    private static void validateRound(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("라운드는 1 라운드 이상부터 가능합니다.");
        }
        if (round > 20) {
            throw new IllegalArgumentException("라운드는 최대 20 라운드까지만 진행할 수 있습니다.");
        }
    }

    public void start() {
        this.printStartPage();
        this.racing();
        this.findWinners();
        this.printResultPage();
    }

    private void printStartPage() {
        Page<String> startPage = new SimpleTextPage();
        startPage.setContent("\n실행 결과");
        startPage.isNewLineAtEOF(true);
        startPage.render();
    }

    private void racing() {
        for (int i = 0; i < this.round; i++) {
            this.racingPerRound();
            this.printRoundPage();
        }
    }

    private void racingPerRound() {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.move()) {
                this.positions.computeIfPresent(vehicle, (key, value) -> ++value);
            }
        }
    }

    private void printRoundPage() {
        Page<String> roundPage = new SimpleTextPage();
        roundPage.isNewLineAtEOF(true);
        StringBuilder content = new StringBuilder();
        for (Vehicle vehicle : this.vehicles) {
            content.append(vehicle.getName());
            content.append(" : ");
            int position = this.positions.get(vehicle);
            content.append("-".repeat(position));
            content.append("\n");
        }
        roundPage.render(content.toString());
    }

    private void findWinners() {
        int maxPosition = this.positions.values().stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException(("서버에 오류가 발생하여 경주 우승자를 찾을 수 없었습니다.")));
        this.positions.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .forEach(entry -> this.winners.add(entry.getKey()));
    }

    private void printResultPage() {
        Page<String> winnersPage = new SimpleTextPage();
        winnersPage.isNewLineAtEOF(true);
        String content = "최종 우승자 : " +
                this.winners.stream()
                .map(Vehicle::getName)
                .collect(Collectors.joining(", "));
        winnersPage.render(content);
    }
}

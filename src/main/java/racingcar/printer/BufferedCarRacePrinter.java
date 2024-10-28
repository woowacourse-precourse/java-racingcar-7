package racingcar.printer;

import racingcar.domain.Car;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class BufferedCarRacePrinter implements Printer {

    private final BufferedWriter writer;

    public BufferedCarRacePrinter(Writer writer) {
        this.writer = new BufferedWriter(writer);
    }

    @Override
    public void writeProgress(List<Car> cars) {
        try {
            for (Car car : cars) {
                writer.write(car.getName() + " : ");
                for (int i = 0; i < car.getLocation(); i++) {
                    writer.write("-");
                }
                writer.write("\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            throw new IllegalArgumentException("IO 오류입니다.");
        }
    }

    public void printProgress() {
        try {
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("IO 오류입니다.");
        }
    }

    @Override
    public void printMessage(String message) {
        try {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("IO 오류입니다.");
        }
    }
}

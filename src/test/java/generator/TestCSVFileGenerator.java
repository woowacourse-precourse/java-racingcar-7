package generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class TestCSVFileGenerator {
    private static final String DELIMITER = ",";
    private static final String QUATOS = "\"";
    private static final int MIN_PROGRESS_COUNT = 1;
    private static final int MAX_PROGRESS_COUNT = 100;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private String generateCarName() {
        int nameLength = Randoms.pickNumberInRange(MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH);
        StringBuilder nameBuilder = new StringBuilder();
        for(int i = 0; i < nameLength; i++) {
            char randomChar = (char) ('a' + Randoms.pickNumberInRange(0, 26));
            nameBuilder.append(randomChar);
        }

        return nameBuilder.toString();
    }

    public String generateCarList(int carCount) {
        Set<String> carNames = new HashSet<>();
        while (carNames.size() < carCount) {
            carNames.add(generateCarName());
        }

        return String.join(DELIMITER, carNames);
    }

    private int generateRandomProgressCount() {
        return Randoms.pickNumberInRange(MIN_PROGRESS_COUNT, MAX_PROGRESS_COUNT);
    }

    public void generateTestCsvFile(String filePath, int dataCount) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (int i = 0; i < dataCount; i++) {
                int randomCarCount = Randoms.pickNumberInRange(2, 50);
                fileWriter.write(QUATOS);
                fileWriter.write(generateCarList(randomCarCount));
                fileWriter.write(QUATOS + ", " + QUATOS);
                fileWriter.write(String.valueOf(generateRandomProgressCount()));
                fileWriter.write(QUATOS);
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException expected) {
            System.out.println("Test CSV File 생성 중 오류가 발생했습니다: " + expected.getMessage());
        }
    }
}

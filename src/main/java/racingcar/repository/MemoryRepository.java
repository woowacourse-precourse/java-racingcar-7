package racingcar.repository;

import racingcar.model.dto.RacingProgress;
import racingcar.model.dto.RacingResult;
import racingcar.model.dto.RacingWinners;
import racingcar.utils.IOMessage;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {

    private final List<String> memory;

    public MemoryRepository() {
        this.memory = new ArrayList<>();
        saveBreakingLine();
    }

    @Override
    public void saveStartMessage() {
        memory.add(IOMessage.RACING_START.toString());
    }

    @Override
    public void saveProgress(RacingProgress progress) {
        memory.add(progress.toString());
    }

    @Override
    public void saveBreakingLine() {
        memory.add("");
    }

    @Override
    public void saveResult(RacingWinners racingWinners) {
        memory.add(IOMessage.WINNER_ANNOUNCEMENT.toString() + racingWinners);
    }

    @Override
    public RacingResult getResult() {
        return new RacingResult(memory);
    }
}

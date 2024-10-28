package racingcar.repository;

import racingcar.model.dto.RacingProgress;
import racingcar.model.dto.RacingRecording;
import racingcar.model.dto.RacingWinners;
import racingcar.utils.message.IOMessage;

import java.util.ArrayList;
import java.util.List;

/** 자동차 경주 결과를 메모리에 저장하는 저장소 */
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
    public RacingRecording getRecord() {
        return new RacingRecording(memory);
    }

}

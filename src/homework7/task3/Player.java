package homework7.task3;

public class Player {
    private long progress = 0;
    private boolean inGame = true;

    public long getProgress() {
        return progress;
    }

    public void setProgress(long progress) {
        this.progress = progress;
    }

    public void addProgress(long progress) {
        this.progress += progress;
    }

    public boolean inGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }


}

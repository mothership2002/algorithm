package abs;

public abstract class Algorithm {
    protected String DURATION = "[duration] : ";
    protected String MILLISECOND = "ms";
    protected long startTime;
    protected long endTime;

    public void run(int keyword) {
        measureAndPrint(() -> searching(keyword));
    }

    public void run() {
        measureAndPrint(this::sorting);
    }

    public void measureAndPrint(Runnable task) {
        System.out.println("=======================================");
        System.out.println(this.getClass().getSuperclass().getSimpleName() + " / " + this.getClass().getSimpleName());
        startTime = System.nanoTime();
        task.run();
        endTime = System.nanoTime();
        double durationMs = ((double) (endTime - startTime) / 1_000_000);
        System.out.println(DURATION + durationMs + MILLISECOND);
    }

    protected void searching(int keyword) {

    }

    protected void sorting() {

    }
}

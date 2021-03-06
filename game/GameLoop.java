package game;

public class GameLoop implements Runnable {
    public static final int UPDATE_PER_SECOND = 60;
    private boolean running;
    private final double updateRate = 1.0d / UPDATE_PER_SECOND;
    private Game game = Game.get();

    private int fps, ups;
    private long nextStatTime;

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while (running) {
            currentTime = System.currentTimeMillis();
            double renderTimeInSecond = (currentTime - lastUpdate) / 1000d;
            accumulator += renderTimeInSecond;
            lastUpdate = currentTime;

            if (accumulator > updateRate) {
                while (accumulator > updateRate) {
                    update();
                    accumulator -= updateRate;
                }
                render();
            }
            printStat();
        }
    }

    private void printStat() {
        if (System.currentTimeMillis() > nextStatTime) {
            System.out.printf("FPS: %d -- UPS: %d%n", fps, ups);
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update() {
        game.update();
        ups++;
    }

    private void render() {
        game.render();
        fps++;
    }
}

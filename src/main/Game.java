package main;

public class Game implements Runnable {
    private final GamePanel gamePanel;

    public Game() {
        gamePanel = new GamePanel();
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int FPS_SET = 144;
        double timePerFrame = 1_000_000_000.0 / FPS_SET;
        long now = System.nanoTime();
        long lastTimeFrame = System.nanoTime();

        long lastCheckMillis = System.currentTimeMillis();
        int frames = 0;

        while (true) {
            now = System.nanoTime();
            if (now - lastTimeFrame >= timePerFrame) {
                gamePanel.repaint();
                lastTimeFrame = now;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheckMillis >= 1000) {
                lastCheckMillis = System.currentTimeMillis();
                System.out.println("FPS : " + frames);
                frames = 0;
            }
        }
    }
}

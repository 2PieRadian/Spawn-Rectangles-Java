package main;

import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

class Rects {
    private int x, y, width, height;
    private Color color;
    int dirX = 2, dirY = 2;
    Random random;

    public Rects(int x, int y) {
        this.x = x;
        this.y = y;

        random = new Random();
        this.width = random.nextInt(20, 80);
        this.height = random.nextInt(20, 80);
        this.color = newColor(random);
    }

    public Color newColor(Random random) {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r, g, b);
    }

    public void updateRect() {
        x += dirX;
        if (x + width >= 1000 || x <= 0) {
            dirX *= -1;
            color = newColor(random);
        }

        y += dirY;
        if (y + height >= 700 || y <= 0) {
            dirY *= -1;
            color = newColor(random);
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

public class GamePanel extends JPanel {
    private ArrayList<Rects> rects = new ArrayList<>();

    public GamePanel() {
        MouseInputs mouseinputs = new MouseInputs(this);
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
    }

    public void spawnRect(int x, int y) {
        rects.add(new Rects(x, y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Rects rect : rects) {
            rect.updateRect();
            rect.draw(g);
        }
    }
}
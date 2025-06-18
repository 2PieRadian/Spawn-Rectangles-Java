# 🟥 Spawn Rectangles Game

A simple Java game where colorful rectangles are spawned on mouse clicks and bounce around the screen with randomized sizes and directions.

## 🎮 Features

- Click to spawn rectangles at your mouse position
- Random color and size for each rectangle
- Bounces off window edges and changes color on impact
- Multiple rectangles supported with smooth animation

## ⚙️ Technical Overview

### 🧩 Components

- **`Rects` Class**  
  Represents each individual rectangle. On creation:
  - Assigned a random `width` and `height` (between 20–80 px)
  - Given a random `Color` (RGB)
  - Starts moving diagonally at a default speed
  - Changes color on hitting window boundaries

- **`GamePanel` Class**  
  - Extends `JPanel` and is responsible for rendering and updating all rectangles
  - Holds an `ArrayList<Rects>` to manage multiple rectangles
  - Registers mouse listeners via `MouseInputs` to detect clicks
  - Calls `spawnRect(x, y)` to add new rectangles at the mouse location
  - Overrides `paintComponent(Graphics g)` to:
    - Clear the screen
    - Update and redraw every rectangle each frame

- **`MouseInputs` Class** (Assumed)  
  - Handles mouse events and passes coordinates to `GamePanel.spawnRect(x, y)`

---

### 🧠 Logic & Behavior

- **Movement**  
  - Each rectangle moves by `dirX` and `dirY` values (default `2`)
  - Movement is handled in `updateRect()` method
  - When a rectangle touches a boundary (0 or width/height of panel), its direction reverses and color changes

- **Collision with Walls**  
  - X direction changes if `x + width > panelWidth` or `x < 0`
  - Y direction changes if `y + height > panelHeight` or `y < 0`

- **Randomization**  
  - Uses `java.util.Random` to generate size and color at instantiation
  - New color is also randomly generated on each bounce

---

### 🖼️ Rendering

- `paintComponent()` is automatically called when the panel is repainted
- Each frame:
  - Clears the panel (via `super.paintComponent(g)`)
  - Loops through all rectangles
    - Calls `updateRect()` for logic
    - Calls `draw(Graphics g)` to render the rectangle on screen

---

### 🚀 Performance Notes

- Currently, the panel does not auto-refresh on its own (no game loop or `Timer`)
- You can improve animation by adding:
  ```java
  new Timer(16, e -> repaint()).start(); // ~60 FPS

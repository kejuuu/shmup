package screens;

import java.awt.*;
import GameFrame.GamePanel;
import states.GameState;
import states.GameStateManager;
import utils.Background;
import utils.GameObject;

public class Level1 extends GameState {

    private Background background;
    private GameObject player;

    public Level1(GameStateManager gsm) {
        this.gsm = gsm;

        background = new Background("../Background/background.png", 1);
        player = new GameObject("../Ships/ship_0000.png");

        player.transform.setPosition(GamePanel.SCREEN_WIDTH / 2 - player.image.getWidth() / 2, 270);
    }

    public void update() {
        background.scrollBg();
    }

    public void draw(Graphics2D g) {
        background.draw(g);
        player.draw(g);
    }

    public void keyPressed(int k) {

    }

    public void keyReleased(int k) {

    }
}

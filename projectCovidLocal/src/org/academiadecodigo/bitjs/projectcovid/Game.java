package org.academiadecodigo.bitjs.projectcovid;

import org.academiadecodigo.bitjs.projectcovid.field.BulletFieldPosition;
import org.academiadecodigo.bitjs.projectcovid.field.Field;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Civilian;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.CivilianFactory;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private Player player;
    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent space;
    private KeyboardEvent s;
    private BulletFieldPosition bullet;
    private Civilian[] civilians;
    private Field field;
    private CivilianFactory civilianFactory;
    private Picture[] healthBar;
    private boolean started;
    private Level actualLevel;
    private Picture[] fullHeartPics;
    private Picture[] emptyHeartPics;


    public Game() {
        this.field = new Field(25, 18);
        field.init();
        civilianFactory = new CivilianFactory(field);
        this.player = new Player(field);
        healthBar = new Picture[3];

    }

    public static void addDelay() {
        try {
            Thread.sleep(30);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void init() {
        bootstrap();
        initHealthPics();
        CollisionDetector.setPlayer(player);

        while (!started) {
            field.init();
        }
    }

    public void start() {
        setLevelMapLogic(Level.level1);


    }

    private void level1Cycle() {


        while (actualLevel == Level.level1) {
            player.showAccordingToDirection();
            for (int i = 0; i < civilians.length; i++) {
                if (bullet != null) {
                    while (bullet != null) {

                        if (!bullet.moveBullet(3)) {
                            bullet.getBullet().getBullet().delete();
                            bullet = null;
                        }


                    }
                }
                CollisionDetector.checkInfections();
                showHealth();
                civilians[i].move();
                addDelay();
            }
        }
    }

    private void setLevelMapLogic(Level level) {
        switch (level) {
            case level1:
                field.deletePicture();
                field.setPicture(new Picture(Field.PADDING, Field.PADDING, "resources/level1.png"));
                field.show();
                actualLevel = Level.level1;
                civilians = makeCivilians(20);
                drawCivilians();
                civilians[0].infect();
                civilians[0].showAccordingToDirection();
                CollisionDetector.setCivilians(civilians);
                level1Cycle();
                field.show();
                break;
            case level2:
                field.deletePicture();
                field.setPicture(new Picture(Field.PADDING, Field.PADDING, "resources/level2Map.png"));
                field.show();
                break;
           /* case endMenu:
                field.deletePicture();
                field.setPicture(new Picture(Field.PADDING,Field.PADDING,"resources/endMenu.png"));
                field.show();
            */
        }

    }

    private void drawCivilians() {
        for (Civilian civilian : civilians) {
            civilian.showAccordingToDirection();
        }
    }


    private void displayHealthBar(int health) {
        for (int i = 0; i <healthBar.length ; i++) {

            if (healthBar[i]!= null) {
                healthBar[i].delete();
            }
        }
        switch (health) {
            case 1:
                healthBar[0] = fullHeartPics[0];
                healthBar[1] = emptyHeartPics[1];
                healthBar[2] = emptyHeartPics[2];
                break;
            case 2:
                healthBar[0] = fullHeartPics[0];
                healthBar[1] = fullHeartPics[1];
                healthBar[2] = emptyHeartPics[2];
                break;
            case 3:
                healthBar[0] = fullHeartPics[0];
                healthBar[1] = fullHeartPics[1];
                healthBar[2] = fullHeartPics[2];
                break;
            default:
                healthBar[0] = emptyHeartPics[0];
                healthBar[1] = emptyHeartPics[1];
                healthBar[2] = emptyHeartPics[2];
                break;
        }
        for (int i = 0; i < healthBar.length; i++) {

            healthBar[i].draw();
        }
    }


    public void showHealth() {
        if (player.getHealth() == 3) {
            displayHealthBar(3);
        } else if (player.getHealth() == 2) {
            displayHealthBar(2);
        } else if (player.getHealth() == 1) {
            displayHealthBar(1);
        }
    }

    public Civilian[] makeCivilians(int numberOfCivilians) {
        Civilian[] newCivilians = new Civilian[numberOfCivilians];
        for (int i = 0; i < numberOfCivilians; i++) {
            newCivilians[i] = civilianFactory.makeCivilian();
        }
        return newCivilians;
    }

    private void bootstrap() {

        Keyboard keyboard = new Keyboard(this);

        right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);

        up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(up);

        down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

        space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

        s = new KeyboardEvent();
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        s.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(s);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == s.getKey()) {
            started = true;
        }

        if (keyboardEvent.getKey() == right.getKey()) {
            player.moveRight();
        }

        if (keyboardEvent.getKey() == left.getKey()) {
            player.moveLeft();
        }

        if (keyboardEvent.getKey() == up.getKey()) {
            player.moveUp();
        }

        if (keyboardEvent.getKey() == down.getKey()) {
            player.moveDown();
        }
        if (keyboardEvent.getKey() == space.getKey()) {
            if (bullet == null) {
                bullet = player.shoot();
            }


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void initHealthPics() {
        fullHeartPics = new Picture[3];
        emptyHeartPics = new Picture[3];
        for (int i = 0; i < fullHeartPics.length; i++) {
            fullHeartPics[i] = new Picture(Field.colsToX(field.getCols() - 3 + i), Field.PADDING, "resources/fullHeart.png");
            emptyHeartPics[i] = new Picture(Field.colsToX(field.getCols() - 3 + i), Field.PADDING, "resources/emptyHeart.png");
            healthBar[i]=fullHeartPics[i];
        }

    }

    public enum Level {
        mainMenu,
        level1,
        level2,
        endMenu
    }
}

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
    private boolean started;
    private Level actualLevel;

    public Game() {
        this.field = new Field(25, 18);
        field.init();
        civilianFactory = new CivilianFactory(field);
        this.player = new Player(field);

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


    public enum Level {
        mainMenu,
        level1,
        level2,
        endMenu
    }
}

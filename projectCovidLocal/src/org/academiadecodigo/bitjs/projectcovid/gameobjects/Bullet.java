package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {

    private Direction direction;
    private Picture bullet;
    private int x, y;


    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        initPicture();
        show();
    }

    public void initPicture() {
        switch (direction) {
            case UP -> bullet = new Picture(x, y, "resources/syringeUp.png");
            case DOWN -> bullet = new Picture(x, y, "resources/syringeDown.png");
            case RIGHT -> bullet = new Picture(x, y, "resources/syringeRight.png");
            case LEFT -> bullet = new Picture(x, y, "resources/syringeLeft.png");
        }
    }

    public void show() {
        bullet.draw();
    }

    public Picture getBullet() {
        return bullet;
    }

    public void bulletDirection(Direction direction) {
        this.direction = direction;
    }


}

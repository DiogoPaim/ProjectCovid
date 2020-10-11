package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.bitjs.projectcovid.CollisionDetector;
import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Bullet;

public class BulletFieldPosition extends FieldPosition{
    private CollisionDetector collisionDetector;
    private Bullet bullet;


    public BulletFieldPosition(CollisionDetector collisionDetector, Field field, int col, int row,
                               Direction direction, Bullet bullet){
        super(row,col,field,direction);
        this.collisionDetector =collisionDetector;
        this.bullet=bullet;
    }

    public void moveBullet(Direction direction, int speed) {

    }

    public void moveBulletDown(int speed) {
        int firstY = super.getY();
        for (int i = 0; i <= speed; i++) {
            super.setRow(super.getRow()+1);
            collisionDetector.checkBulletHit();
        }
        super.setY(Field.rowsToY(super.getRow()));
        int difY= super.getY()-firstY;
        this.bullet.getBullet().translate(0,difY);
        this.bullet.show();
    }

    public void moveBulletUp() {
    }

    public void moveBulletRight() {
    }

    public void moveBulletLeft() {
    }
}

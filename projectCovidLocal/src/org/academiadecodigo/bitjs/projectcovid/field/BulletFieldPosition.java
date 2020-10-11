package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.bitjs.projectcovid.CollisionDetector;
import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Bullet;

public class BulletFieldPosition extends FieldPosition{
    private CollisionDetector collisionDetector;
    private Bullet bullet;


    public BulletFieldPosition(CollisionDetector collisionDetector, Field field, int col, int row,
                               Direction direction){
        super(col,row,field,direction);
        this.collisionDetector =collisionDetector;
        this.bullet=new Bullet(Field.colsToX(super.getCol()),Field.rowsToY(super.getRow()));
    }

    public void moveBullet(Direction direction, int speed) {

    }

    public Bullet getBullet() {
        return bullet;
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

    public void moveBulletUp(int speed) {
        int firstY = super.getY();
        for (int i = 0; i <= speed; i++) {
            super.setRow(super.getRow()-1);
            collisionDetector.checkBulletHit();
        }
        super.setY(Field.rowsToY(super.getRow()));
        int difY= super.getY()-firstY;
        this.bullet.getBullet().translate(0,difY);
        this.bullet.show();
    }

    public void moveBulletRight(int speed) {
        int firstX = super.getX();
        for (int i = 0; i <= speed; i++) {
            super.setCol(super.getCol()+1);
            collisionDetector.checkBulletHit();
        }
        super.setX(Field.colsToX(super.getCol()));
        int difX = super.getX()-firstX;
        this.bullet.getBullet().translate(difX,0);
        this.bullet.show();
    }

    public void moveBulletLeft(int speed) {
        int firstX = super.getX();
        for (int i = 0; i <= speed; i++) {
            super.setCol(super.getCol()-1);
            collisionDetector.checkBulletHit();
        }
        super.setX(Field.colsToX(super.getCol()));
        int difX = super.getX()-firstX;
        this.bullet.getBullet().translate(difX,0);
        this.bullet.show();
    }
}

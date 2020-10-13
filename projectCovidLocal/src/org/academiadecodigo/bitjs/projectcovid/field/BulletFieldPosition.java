package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.bitjs.projectcovid.CollisionDetector;
import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Bullet;

public class BulletFieldPosition extends FieldPosition{

    private Bullet bullet;


    public BulletFieldPosition( Field field, int col, int row,
                               Direction direction){
        super(col,row,field,direction);

        this.bullet=new Bullet(Field.colsToX(super.getCol()),Field.rowsToY(super.getRow()));
    }

    public void moveBullet( int speed) {
        switch (super.getActualDirection()){
            case LEFT -> moveBulletLeft(speed);
            case RIGHT -> moveBulletRight(speed);
            case DOWN -> moveBulletDown(speed);
            case UP -> moveBulletUp(speed);
        }
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void moveBulletDown(int speed) {

        for (int i = 0; i <= speed; i++) {
            int firstY = super.getY();
            super.setRow(super.getRow()+1);
            CollisionDetector.checkBulletHit(this);
            int difY= super.getY()-firstY;
            this.bullet.getBullet().translate(0,difY);
            this.bullet.show();
            addDelay(5);
        }

    }

    public void moveBulletUp(int speed) {

        for (int i = 0; i <= speed; i++) {
            int firstY = super.getY();
            super.setRow(super.getRow()-1);
            CollisionDetector.checkBulletHit(this);
            int difY= super.getY()-firstY;
            this.bullet.getBullet().translate(0,difY);
            this.bullet.show();
            addDelay(5);
        }

    }

    public void moveBulletRight(int speed) {

        for (int i = 0; i <= speed; i++) {
            int firstX = super.getX();
            super.setCol(super.getCol()+1);
            CollisionDetector.checkBulletHit(this);
            int difX = super.getX()-firstX;
            this.bullet.getBullet().translate(difX,0);
            this.bullet.show();
            addDelay(5);
        }

    }

    public void moveBulletLeft(int speed) {

        for (int i = 0; i <= speed; i++) {
            int firstX = super.getX();
            super.setCol(super.getCol()-1);
            CollisionDetector.checkBulletHit(this);
            int difX = super.getX()-firstX;
            this.bullet.getBullet().translate(difX,0);
            this.bullet.show();
            addDelay(5);
        }

    }

    public void addDelay(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }catch (Exception e){

        }
    }
}

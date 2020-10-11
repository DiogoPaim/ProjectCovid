package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.field.BulletFieldPosition;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {

    private Direction direction;
    private Picture bullet;


    public Bullet (int x, int y){
        this.bullet = new Picture(x,y, "resources/PinClipart.png");


        show();
    }

    public void setInitialPos(){

    }
    public void show(){
        bullet.draw();
    }

    public Picture getBullet() {
        return bullet;
    }

    public void bulletDirection (Direction direction){
        this.direction = direction;
    }

    

}

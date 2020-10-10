package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {

    private Direction direction;
    private Picture bullet;
    private FieldPosition fieldPosition;

    public Bullet (FieldPosition position){
        this.bullet = new Picture(20,20, "resources/PinClipart.png");
        this.fieldPosition = position;

        init();
    }

    public void init(){
        bullet.draw();
    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }

    public void bulletDirection (Direction direction){
        this.direction = direction;
    }

    

}

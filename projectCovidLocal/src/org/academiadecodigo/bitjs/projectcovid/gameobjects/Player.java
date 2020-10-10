package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int health;
    private Picture player;
    private FieldPosition fieldPosition;

    public Player(FieldPosition position) {
        this.player = new Picture(15,15, "resources/right.png");
        this.fieldPosition = position;

        init();
    }

    public void init(){
        player.draw();
    }

    public void moveRight(){
        player.translate(15,0);
        fieldPosition.setCol(fieldPosition.getCol() + 15);
    }

    public void moveLeft(){
        player.translate(-15,0);
        fieldPosition.setCol(fieldPosition.getCol() - 15);
    }

    public void moveUp(){
        player.translate(0,- 15);
        fieldPosition.setRow(fieldPosition.getRow() - 15);
    }

    public void moveDown(){
        player.translate(0,15);
        fieldPosition.setRow(fieldPosition.getRow() + 15);
    }

}

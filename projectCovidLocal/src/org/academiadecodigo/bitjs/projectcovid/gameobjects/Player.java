ppackage org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.field.Field;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int health;
    private Picture player;
    private FieldPosition fieldPosition;


    public Player(FieldPosition position) {

        this.fieldPosition = position;
        this.player = new Picture(fieldPosition.getX(),fieldPosition.getY(), "resources/right.png");



        init();
    }

    public void init(){
        player.draw();
    }

    public void moveRight(){
        if (fieldPosition.getCol() < fieldPosition.getField().getCols()) {
            player.translate(15, 0);
            fieldPosition.setCol(fieldPosition.getCol() + 1);
        }
        return;
    }

    public void moveLeft() {
        if (fieldPosition.getCol() > 0) {
            player.translate(-15, 0);
            fieldPosition.setCol(fieldPosition.getCol() - 1);
        }
        return;
    }

    public void moveUp(){
        if (fieldPosition.getRow() > 0) {
            player.translate(0,- 15);
            fieldPosition.setRow(fieldPosition.getRow() - 1);
        }
        return;
    }

    public void moveDown(){
        if (fieldPosition.getRow() <fieldPosition.getField().getRows()) {
            player.translate(0, 15);
            fieldPosition.setRow(fieldPosition.getRow() + 1);
        }
        return;
    }

}

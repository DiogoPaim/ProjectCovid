package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.field.BulletFieldPosition;
import org.academiadecodigo.bitjs.projectcovid.field.Field;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int health;
    private Picture playerPicture;
    private FieldPosition fieldPosition;
    private Picture playerPictureLeft;
    private Picture playerPictureRight;
    private Picture playerPictureDown;
    private Picture playerPictureUp;


    public Player(Field field) {

        this.health = 3;
        this.fieldPosition = new FieldPosition((int) Math.floor(field.getCols() / 2),
                (int) Math.floor(field.getRows() / 2), field, Direction.UP);
        playerPictureLeft = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerLeft.png");
        playerPictureRight = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerRight.png");
        playerPictureUp = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerUp.png");
        playerPictureDown = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerDown.png");
        this.playerPicture = playerPictureDown;
        showAccordingToDirection();
    }

    public void showAccordingToDirection() {

            playerPicture.delete();

        switch (fieldPosition.getActualDirection()) {

            case LEFT:
              playerPictureLeft.translate(fieldPosition.getX()-playerPictureLeft.getX(), fieldPosition.getY()-playerPictureLeft.getY());
              playerPicture=playerPictureLeft;
                break;
            case RIGHT:
                playerPictureRight.translate(fieldPosition.getX()-playerPictureRight.getX(), fieldPosition.getY()-playerPictureRight.getY());
                playerPicture=playerPictureRight;
                break;
            case UP:
                playerPictureUp.translate(fieldPosition.getX()-playerPictureUp.getX(), fieldPosition.getY()-playerPictureUp.getY());
                playerPicture=playerPictureUp;
                break;
            case DOWN:
                playerPictureDown.translate(fieldPosition.getX()-playerPictureDown.getX(), fieldPosition.getY()-playerPictureDown.getY());
                playerPicture=playerPictureDown;
                break;
        }

        playerPicture.draw();

    }

    public void moveRight() {
        if (fieldPosition.getActualDirection() != Direction.RIGHT) {
            fieldPosition.setActualDirection(Direction.RIGHT);
            showAccordingToDirection();
            return;
        }
        if (fieldPosition.getCol() < fieldPosition.getField().getCols() - 1) {
            fieldPosition.setCol(fieldPosition.getCol() + 1);
            fieldPosition.setActualDirection(Direction.RIGHT);
            showAccordingToDirection();
        }

    }

    public void moveLeft() {
        if (fieldPosition.getActualDirection() != Direction.LEFT) {
            fieldPosition.setActualDirection(Direction.LEFT);
            showAccordingToDirection();
            return;
        }
        if (fieldPosition.getCol() > 0) {
            fieldPosition.setCol(fieldPosition.getCol() - 1);
            fieldPosition.setActualDirection(Direction.LEFT);
            showAccordingToDirection();
        }

    }

    public void moveUp() {
        if (fieldPosition.getActualDirection() != Direction.UP) {
            fieldPosition.setActualDirection(Direction.UP);
            showAccordingToDirection();
            return;
        }
        if (fieldPosition.getRow() > 0) {
            fieldPosition.setRow(fieldPosition.getRow() - 1);
            fieldPosition.setActualDirection(Direction.UP);
            showAccordingToDirection();
        }

    }

    public void moveDown() {
        if (fieldPosition.getActualDirection() != Direction.DOWN) {
            fieldPosition.setActualDirection(Direction.DOWN);
            showAccordingToDirection();
            return;
        }
        if (fieldPosition.getRow() < fieldPosition.getField().getRows() - 1) {
            fieldPosition.setRow(fieldPosition.getRow() + 1);
            fieldPosition.setActualDirection(Direction.DOWN);
            showAccordingToDirection();
        }

    }

    public BulletFieldPosition shoot() {
        System.out.println("bullet shot");

        switch (fieldPosition.getActualDirection()) {

            case UP:
                return new BulletFieldPosition(fieldPosition.getField(), fieldPosition.getCol()
                        , fieldPosition.getRow() - 1, Direction.UP);

            case DOWN:
                return new BulletFieldPosition(fieldPosition.getField(), fieldPosition.getCol()
                        , fieldPosition.getRow() + 1, Direction.DOWN);
            case RIGHT:
                return new BulletFieldPosition(fieldPosition.getField(), fieldPosition.getCol() + 1
                        , fieldPosition.getRow(), Direction.RIGHT);

            case LEFT:
                return new BulletFieldPosition(fieldPosition.getField(), fieldPosition.getCol() - 1
                        , fieldPosition.getRow(), Direction.LEFT);

        }


        return null;
    }

    public int getHealth(){
        return health;
    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }


}

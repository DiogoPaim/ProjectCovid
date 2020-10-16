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


    public Player(Field field) {

        this.fieldPosition = new FieldPosition((int) Math.floor(field.getCols() / 2),
                (int) Math.floor(field.getRows() / 2), field, Direction.UP);

        this.playerPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerDown.png");
        showAccordingToDirection();
    }

    public void showAccordingToDirection() {

            playerPicture.delete();

        switch (fieldPosition.getActualDirection()) {

            case LEFT:
                playerPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerLeft.png");
                break;
            case RIGHT:
                playerPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerRight.png");
                break;
            case UP:
                playerPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerUp.png");
                break;
            case DOWN:
                playerPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/playerDown.png");
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
        return;
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
        return;
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
        return;
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
        return;
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

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }


}

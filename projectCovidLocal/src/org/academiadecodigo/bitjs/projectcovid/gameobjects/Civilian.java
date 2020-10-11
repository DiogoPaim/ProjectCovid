package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Civilian {

    private boolean infected;
    private FieldPosition fieldPosition;
    private Picture actualPicture;

    public Civilian(FieldPosition position) {
        this.fieldPosition = position;
        infected = false;
        actualPicture=new Picture(fieldPosition.getX(),fieldPosition.getY(),"resources/civilianDown.png");
        showAccordingToDirection();
    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }

    public boolean isInfected() {
        return infected;
    }

    public void cure() {
        this.infected = false;
    }

    public void infect() {
        this.infected = true;
    }

    public void showAccordingToDirection() {
        actualPicture.delete();
        switch (fieldPosition.getActualDirection()) {
            case UP -> actualPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/civilianUp.png");
            case DOWN -> actualPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/civilianDown.png");
            case LEFT -> actualPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/civilianLeft.png");
            case RIGHT -> actualPicture = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/civilianRight.png");


        }
        actualPicture.draw();
    }

    public void move() {
        int random = (int) (Math.random() * 10);

        switch (fieldPosition.getActualDirection()) {
            case RIGHT:
                if (random > 1) {
                    moveRight();
                } else if (random == 1) {
                    moveUp();
                } else {
                    moveDown();

                    break;
                }
            case LEFT:
                if (random > 1) {
                    moveLeft();
                } else if (random == 1) {
                    moveUp();
                } else {
                    moveDown();
                }
                break;
            case DOWN:
                if (random > 1) {
                    moveDown();
                } else if (random == 1) {
                    moveLeft();
                } else {
                    moveRight();
                }
                break;
            case UP:
                if (random > 1) {
                    moveUp();
                } else if (random == 1) {
                    moveLeft();
                } else {
                    moveRight();
                }
                break;
        }
    }


    public void moveRight() {

        if (fieldPosition.getCol() < fieldPosition.getField().getCols() - 1) {
            fieldPosition.moveRight();
            fieldPosition.setActualDirection(Direction.RIGHT);
            showAccordingToDirection();
        }
    }

    public void moveLeft() {

        if (fieldPosition.getCol() > 0) {
            fieldPosition.moveLeft();
            fieldPosition.setActualDirection(Direction.LEFT);
            showAccordingToDirection();
        }
    }

    public void moveUp() {

        if (fieldPosition.getRow() > 0) {
            fieldPosition.moveUp();
            fieldPosition.setActualDirection(Direction.UP);
            showAccordingToDirection();
        }
    }

    public void moveDown() {

        if (fieldPosition.getRow() < fieldPosition.getField().getRows() - 1) {
            fieldPosition.moveDown();
            fieldPosition.setActualDirection(Direction.DOWN);
            showAccordingToDirection();
        }
    }


}

package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.bitjs.projectcovid.CollisionDetector;
import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldPosition {
    private int row;
    private int col;
    private int x;
    private int y;
    private Field field;

    private Direction actualDirection;


    public FieldPosition(Field field) {
        this.field = field;
        this.col = (int) (Math.random() * this.field.getCols());
        this.row = (int) (Math.random() * this.field.getRows());
        this.x = field.colsToX(this.col);
        this.y = field.rowsToY(this.row);
        actualDirection = Direction.values()[(int) Math.random() * Direction.values().length];


    }

    public FieldPosition(int col, int row, Field field, Direction direction) {
        this.col = col;
        this.row = row;
        this.field = field;

        this.x = field.colsToX(this.col);
        this.y = field.rowsToY(this.row);

        actualDirection = direction;


    }



    public int moveRight() {
        if (CollisionDetector.checkMovement(this.col + 1, this.row)) {
            int lastX = this.x;

            this.col++;
            this.x = field.colsToX(this.col);

            int difX = this.x - lastX;
            return difX;

        }
        return 0;
    }
    public int moveLeft() {
        if (CollisionDetector.checkMovement(this.col - 1, this.row)) {
            int lastX = this.x;

            this.col--;
            this.x = field.colsToX(this.col);

            int difX = this.x - lastX;
            return difX;

        }
        return 0;
    }

    public int moveUp() {
        if (CollisionDetector.checkMovement(this.col , this.row-1)) {
            int lastY = this.y;
            this.row--;
            this.y = field.rowsToY(this.row);

            int difY = this.y - lastY;
            return difY;
        }
        return 0;
    }

    public int moveDown() {
        if (CollisionDetector.checkMovement(this.col, this.row + 1)) {
            int lastY = this.y;
            this.row++;
            this.y = field.rowsToY(this.row);

            int difY = this.y - lastY;
            return difY;

        }
        return 0;
    }

    // it is an OVERRIDE BUT it doesn't receive an object it
    public boolean equals(int col, int row) {
        if (this.col == col && this.row == row) {
            return true;
        }
        return false;
    }

    public Field getField() {
        return field;
    }

    public Direction getActualDirection() {
        return actualDirection;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getX() {
        return Field.PADDING + col * Field.CELL_SIZE;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setActualDirection(Direction actualDirection) {
        this.actualDirection = actualDirection;
    }

    public int getY() {
        return Field.PADDING + row * Field.CELL_SIZE;
    }

    public void setY(int y) {
        this.y = y;
    }
}

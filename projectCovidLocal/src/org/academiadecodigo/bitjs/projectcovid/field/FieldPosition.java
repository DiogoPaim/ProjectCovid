package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldPosition {
    private int row;
    private int col;
    private int x;
    private int y;
    private Field field;
    private Picture sketch;
    private Direction actualDirection;

    public FieldPosition(Field field) {
        this.field = field;
        this.col = (int) (Math.random() * this.field.getCols());
        this.row = (int) (Math.random() * this.field.getRows());
        this.x = field.colsToX(this.col);
        this.y = field.rowsToY(this.row);
        actualDirection = Direction.values()[(int) Math.random() * Direction.values().length];

        //sketch = new Rectangle(this.x, this.y, field.getCellSize(), field.getCellSize());
        this.sketch = new Picture(this.x,this.y,"resources/up.png");
        sketch.draw();

        //sketch.fill();
    }

    public FieldPosition(int col, int row, Field field) {
        this.col = col;
        this.row = row;
        this.field = field;

        this.x = field.colsToX(this.col);
        this.y = field.rowsToY(this.row);

        actualDirection = Direction.values()[(int) Math.random() * Direction.values().length];
        //sketch = new Rectangle(this.x, this.y, field.getCellSize(), field.getCellSize());
        this.sketch = new Picture(this.x,this.y,"resources/up.png");

        sketch.draw();



        //sketch.fill();

    }

    public void move() {


    }

    public void moveRight() {
        int lastX = this.x;

        this.col++;
        this.x = field.colsToX(this.col);

        int difX = this.x - lastX;
        sketch.translate(difX, 0);

    }

    public void moveLeft() {
        int lastX = this.x;

        this.col--;
        this.x = field.colsToX(this.col);

        int difX = this.x - lastX;
        sketch.translate(difX, 0);

    }

    public void moveUp() {
        int lastY = this.y;
        this.row--;
        this.y = field.rowsToY(this.row);

        int difY = this.y - lastY;
        sketch.translate(0, difY);
    }

    public void moveDown() {
        int lastY = this.y;
        this.row++;
        this.y = field.rowsToY(this.row);

        int difY = this.y - lastY;
        sketch.translate(0, difY);

    }

    public void moveBullet(Direction direction, int speed) {

    }

    public void moveBulletDown() {
    }

    public void moveBulletUp() {
    }

    public void moveBulletRight() {
    }

    public void moveBulletLeft() {
    }



    // it is an OVERRIDE BUT it doesn't receive an object it
    public boolean equals(int col, int row) {
        if (this.col == col && this.row == row) {
            return true;
        }
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}

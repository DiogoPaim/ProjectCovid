package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    private static final int CELL_SIZE = 15;
    private static final int PADDING = 10;
    private int cols;
    private int rows;
    private Rectangle field;


    public Field(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;

    }

    public void init() {
        this.field = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        field.draw();
    }

    public int colsToX(int cols) {
        return PADDING + (cols * CELL_SIZE);
    }

    public int rowsToY(int rows) {
        return PADDING + (rows * CELL_SIZE);
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

}

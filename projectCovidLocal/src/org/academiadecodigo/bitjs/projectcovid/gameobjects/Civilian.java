package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.*;

public class Civilian {

    private boolean infected;
    private FieldPosition fieldPosition;
    private Picture actualPicture;
    public Civilian(FieldPosition position){
        this.fieldPosition=position;
        infected=false;
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

    public void infect(){
        this.infected=true;
    }

    public void showAccordingToDirection(){ switch (fieldPosition.getActualDirection()){
        case UP -> actualPicture =  new Picture(fieldPosition.getX(),fieldPosition.getY(),"resources/up.png");
        //  case DOWN -> actualPicture= new Picture(fieldPosition.getX(),fieldPosition.getY(),"resources/down.png");
        //   case LEFT -> actualPicture=new Picture(fieldPosition.getX(),fieldPosition.getY(),"resources/left.png");
        case RIGHT -> actualPicture=new Picture(fieldPosition.getX(),fieldPosition.getY(),"resources/right.png");
        default -> actualPicture=new Picture(fieldPosition.getX(),fieldPosition.getY(),"resources/right.png");

    }
    actualPicture.draw();
    }
}

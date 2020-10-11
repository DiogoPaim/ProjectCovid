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
        //case UP -> actualPicture =  new Picture(fieldPosition.getX(),fieldPosition.getY(),"");
        //  case DOWN -> actualPicture= new Picture(fieldPosition.getX(),fieldPosition.getY(),"");
        //   case LEFT -> actualPicture=new Picture(fieldPosition.getX(),fieldPosition.getY(),"");
        //case RIGHT -> actualPicture=new Picture(fieldPosition.getX(),fieldPosition.getY(),"");
        default -> actualPicture=new Picture(fieldPosition.getX(),fieldPosition.getY(),"resources/playerUp.png");

    }
    actualPicture.draw();
    }
}

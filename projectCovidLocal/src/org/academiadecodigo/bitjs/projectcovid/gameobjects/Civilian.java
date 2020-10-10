package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;

public class Civilian {

    private boolean infected;
    private FieldPosition fieldPosition;

    public Civilian(FieldPosition position){
        this.fieldPosition=position;
        infected=false;
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
    public void show(){

    }
}

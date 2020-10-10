package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.field.Field;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;

public class CivilianFactory {
    private Field field;

    public CivilianFactory(Field field){
        this.field=field;
    }
    public Civilian makeCivilian(){

        return new Civilian(new FieldPosition(field));

    }
    public Civilian makeCivilianClose(FieldPosition position){

        return new Civilian(new FieldPosition(position.getCol()+1, position.getRow(), field));
    }
}
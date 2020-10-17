package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.field.Field;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;

public class CivilianFactory {
    private Field field;

    public CivilianFactory(Field field){
        this.field=field;
    }
    public Civilian makeCivilian(){
        double random = Math.random();

        return (random < 0.5) ? new Civilian(new FieldPosition(field)) : new CivilianRapper(new FieldPosition(field));

    }

    public Civilian makeCivilianLevel2(){
        double random = Math.random();

        return (random < 0.5) ? new CivilianGrandma(new FieldPosition(field)) : new CivilianPolice(new FieldPosition(field));
    }

    public Civilian makeCivilianClose(FieldPosition position){

        return new Civilian(new FieldPosition(position.getCol()+1, position.getRow(), field, Direction.LEFT));
    }

    public Civilian makeCivilianClose(){

        return new Civilian(new FieldPosition(1, 18, field, Direction.LEFT));
    }
}


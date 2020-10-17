package org.academiadecodigo.bitjs.projectcovid.gameobjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;

public class CivilianGrandma extends Civilian{


    public CivilianGrandma(FieldPosition fieldPosition){
        super(fieldPosition);
    }



    @Override
    public void bootPictures(){
        super.setInfectedPictureUp(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/CivilianGrandma/grandmaUpInfected.png"));
        super.setInfectedPictureDown(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/CivilianGrandma/grandmaDownInfected.png"));
        super.setInfectedPictureLeft(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/CivilianGrandma/grandmaLeftInfected.png"));
        super.setInfectedPictureRight(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/CivilianGrandma/grandmaRightInfected.png"));
        super.setCivilianPictureUp(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/CivilianGrandma/grandmaUp.png"));
        super.setCivilianPictureDown(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/CivilianGrandma/grandmaDown.png"));
        super.setCivilianPictureLeft(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/CivilianGrandma/grandmaLeft.png"));
        super.setCivilianPictureRight(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/CivilianGrandma/grandmaRight.png"));

        super.setActualPicture(super.getCivilianPictureDown());
    }
}


package org.academiadecodigo.bitjs.projectcovid.gameobjects;


import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CivilianRapper extends Civilian {

    public CivilianRapper(FieldPosition fieldPosition){
        super(fieldPosition);
    }



    @Override
    public void bootPictures(){
        super.setInfectedPictureUp(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/Civilians2/civilianUpInfected2.png"));
        super.setInfectedPictureDown(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/Civilians2/civilianDownInfected2.png"));
        super.setInfectedPictureLeft(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/Civilians2/civilianLeftInfected2.png"));
        super.setInfectedPictureRight(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/Civilians2/civilianRightInfected2.png"));
        super.setCivilianPictureUp(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/Civilians2/civilianUp2.png"));
        super.setCivilianPictureDown(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/Civilians2/civilianDown2.png"));
        super.setCivilianPictureLeft(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/Civilians2/civilianLeft2.png"));
        super.setCivilianPictureRight(new Picture(super.getFieldPosition().getX(), super.getFieldPosition().getY(), "resources/Images/Civilians2/civilianRight2.png"));

        super.setActualPicture(super.getCivilianPictureDown());
    }
}

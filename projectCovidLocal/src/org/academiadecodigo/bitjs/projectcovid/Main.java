package org.academiadecodigo.bitjs.projectcovid;

import org.academiadecodigo.bitjs.projectcovid.field.BulletFieldPosition;
import org.academiadecodigo.bitjs.projectcovid.field.Field;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Bullet;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Civilian;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.CivilianFactory;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Player;

public class Main {

    public static void main(String[] args) {
        Civilian[] civilians =new Civilian[20];
        BulletFieldPosition[] bullets = new BulletFieldPosition[2];

        Field field = new Field(25, 18);
        field.init();
        CivilianFactory civilianFactory = new CivilianFactory(field);
        FieldPosition fieldPosition = new FieldPosition(field);
        Player player = new Player(fieldPosition);

        Game game = new Game(player);

        game.init();


       /* try{
        Thread.sleep(200);}catch (Exception e){
            System.out.println("error in thread sleep");
        }
        fieldPosition.moveRight();
        try{
            Thread.sleep(200);}catch (Exception e){
            System.out.println("error in thread sleep");
        }
        fieldPosition.moveRight();
        try{
            Thread.sleep(200);}catch (Exception e){
            System.out.println("error in thread sleep");
        }
        fieldPosition.moveUp();
        try{
            Thread.sleep(200);}catch (Exception e){
            System.out.println("error in thread sleep");
        } */
        for (int i = 0; i < civilians.length; i++) {
            civilians[i]= civilianFactory.makeCivilian();
        }
        CollisionDetector.setCivilians(civilians);
        CollisionDetector.setPlayer(player);

        for(Civilian civilian :civilians){

            civilian.showAccordingToDirection();
        }

        BulletFieldPosition bullet1position= new BulletFieldPosition(field,20,15,Direction.DOWN);
        bullets[0]=bullet1position;
        BulletFieldPosition bullet2position = new BulletFieldPosition(field,5,20,Direction.UP);
        bullets[1]=bullet2position;

        for (int i = 0; i < 6; i++) {
            bullet1position.moveBulletUp(3);
        }

        CollisionDetector.checkInfections();
        System.out.println(civilians[2].isInfected()) ;
        civilians[0].infect();
        while (true){
            for (int i = 0; i < civilians.length; i++) {
                civilians[i].move();
                addDelay();
                CollisionDetector.checkInfections();
            }
        }
        }


        public static void addDelay(){
        try {
            Thread.sleep(20);
        }catch(Exception e){

        }

        }
    }

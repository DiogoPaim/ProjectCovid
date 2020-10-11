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
        Civilian[] civilians =new Civilian[3];
        BulletFieldPosition[] bullets = new BulletFieldPosition[1];

        Field field = new Field(100, 50);
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

        civilians[1]=civilianFactory.makeCivilianClose(fieldPosition);
        civilians[0]=civilianFactory.makeCivilian();
        civilians[0].infect();
        civilians[2]=civilianFactory.makeCivilianClose();
        civilians[2].infect();
        for(Civilian civilian :civilians){
            civilian.showAccordingToDirection();
        }
        CollisionDetector collisionDetector= new CollisionDetector(civilians,bullets);
        Bullet bullet1 = new Bullet();
        BulletFieldPosition bullet1position= new BulletFieldPosition(collisionDetector,field,1,1,Direction.RIGHT,bullet1);
        bullets[0]=bullet1position;

        bullets[0].moveBulletDown(3);
        addDelay();
        bullets[0].moveBulletDown(3);
        addDelay();
        bullets[0].moveBulletDown(3);
        addDelay();
        bullets[0].moveBulletDown(3);
        addDelay();
        bullets[0].moveBulletDown(3);

        collisionDetector.checkInfections();
        System.out.println(civilians[2].isInfected()) ;



        }

        public static void addDelay(){
        try {
            Thread.sleep(300);
        }catch(Exception e){

        }

        }
    }

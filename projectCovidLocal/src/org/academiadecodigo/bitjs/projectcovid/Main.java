package org.academiadecodigo.bitjs.projectcovid;

import org.academiadecodigo.bitjs.projectcovid.field.Field;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Bullet;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Civilian;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.CivilianFactory;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Player;

public class Main {

    public static void main(String[] args) {
        Civilian[] civilians =new Civilian[2];
        Bullet[] bullets = new Bullet[1];

        Field field = new Field(80, 70);
        field.init();
        CivilianFactory civilianFactory = new CivilianFactory(field);
        FieldPosition fieldPosition = new FieldPosition(field);
        Civilian civilian1 = new Civilian(fieldPosition);
        Player player = new Player(fieldPosition);
        Bullet bullet1 = new Bullet(fieldPosition);
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
        civilians[0]=civilian1;
        civilians[0].infect();
        bullets[0] = new Bullet(fieldPosition);

        CollisionDetector collisionDetector= new CollisionDetector(civilians,bullets);


        collisionDetector.checkInfections();
        collisionDetector.checkBulletHit();



        }

    }

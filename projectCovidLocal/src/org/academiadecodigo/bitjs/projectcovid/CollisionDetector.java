package org.academiadecodigo.bitjs.projectcovid;

import org.academiadecodigo.bitjs.projectcovid.field.BulletFieldPosition;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Civilian;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Player;

public class CollisionDetector {

    private static Civilian[] civilians;
    private static Player player;

    // especie de paredes   private Wall[] walls   para testar se as balas ou nós batemos nas paredes
    // Falta parametros aqui ainda nao tinha as outras coisas para testar

    public static void setCivilians(Civilian[] civiliansArray) {
        civilians = civiliansArray;
    }

    public static void setPlayer(Player player1) {
        player = player1;
    }

    public static void checkInfections() {
        for (int i = 0; i < civilians.length; i++) {

            for (int j = i + 1; j < civilians.length; j++) {


                if (civilians[i].isInfected() || civilians[j].isInfected()) {
                    if (checkInRange(1, civilians[i].getFieldPosition(), civilians[j].getFieldPosition())) {
                        civilians[i].infect();
                        civilians[j].infect();
                        System.out.println("a Civilian was infected");
                    }
                }

            }

        }

    }

    public static void checkBulletHit(BulletFieldPosition bulletFieldPosition) {

        for (int j = 0; j < civilians.length; j++) {
            if (civilians[j].isInfected()) {
                int col = civilians[j].getFieldPosition().getCol();
                int row = civilians[j].getFieldPosition().getRow();
                if (bulletFieldPosition.equals(col, row)) {
                    civilians[j].cure();
                    System.out.println("A civilian was cured");
                }
            }

        }
    }

    public static boolean checkMovement(int col, int row){
        for (int i = 0; i < civilians.length; i++) {
           if( civilians[i].getFieldPosition().getCol()==col && civilians[i].getFieldPosition().getRow()==row){
               return false;
           }
        }
        if (player.getFieldPosition().getCol()==col&& player.getFieldPosition().getRow()==row){
            return false;
        }
       return true;


    }


    public static boolean checkInRange(int range, FieldPosition position1, FieldPosition position2) {

        for (int i = 1; i <= range; i++) {
            if (position1.equals(position2.getCol() + i, position2.getRow())) {
                return true;
            }
            if (position1.equals(position2.getCol() - i, position2.getRow())) {
                return true;
            }
            if (position1.equals(position1.getCol(), position2.getRow() + i)) {
                return true;
            }
            if (position1.equals(position1.getCol(), position2.getRow() - i)) {
                return true;
            }
        }
        return false;
    }
}

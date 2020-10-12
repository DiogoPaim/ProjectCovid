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
            if (civilians[i].isInfected()) {
                Civilian civilianToInfect = checkForCivilianInRange(1, civilians[i].getFieldPosition());
                if (civilianToInfect != null) {
                    civilianToInfect.infect();
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

    public static boolean checkMovement(int col, int row) {
        for (int i = 0; i < civilians.length; i++) {
            if (civilians[i].getFieldPosition().getCol() == col && civilians[i].getFieldPosition().getRow() == row) {
                return false;
            }
        }
        if (player.getFieldPosition().getCol() == col && player.getFieldPosition().getRow() == row) {
            return false;
        }
        return true;


    }


    public static Civilian checkForCivilianInRange(int range, FieldPosition position1) {

        for (int i = 1; i <= range; i++) {
            if (isCivilianHere(position1.getCol() + i, position1.getRow()) != null) {
                return isCivilianHere(position1.getCol() + i, position1.getRow());
            }
            if (isCivilianHere(position1.getCol() - i, position1.getRow()) != null) {
                return isCivilianHere(position1.getCol() - i, position1.getRow());
            }
            if (isCivilianHere(position1.getCol(), position1.getRow() + i) != null) {
                return isCivilianHere(position1.getCol(), position1.getRow() + i);
            }
            if (isCivilianHere(position1.getCol(), position1.getRow() - i) != null) {
                return isCivilianHere(position1.getCol(), position1.getRow() - i);
            }
        }
        return null;
    }

    public static Civilian isCivilianHere(int col, int row) {
        boolean result = false;
        for (Civilian civilian : civilians) {
            if (civilian.getFieldPosition().getCol() == col && civilian.getFieldPosition().getRow() == row) {
                return civilian;
            }
        }
        return null;
    }
}

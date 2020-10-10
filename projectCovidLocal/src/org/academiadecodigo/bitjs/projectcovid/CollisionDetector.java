package org.academiadecodigo.bitjs.projectcovid;

import org.academiadecodigo.bitjs.projectcovid.field.BulletFieldPosition;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Bullet;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Civilian;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Player;

public class CollisionDetector {

    private Civilian[] civilians;
    private Player player;
    private BulletFieldPosition[] bulletFieldPositions;

    // especie de paredes   private Wall[] walls   para testar se as balas ou nós batemos nas paredes
    // Falta parametros aqui ainda nao tinha as outras coisas para testar
    public CollisionDetector(Civilian[] civilians, BulletFieldPosition[] bullets) {
        this.civilians = civilians;
        this.bulletFieldPositions = bullets;

    }

    public void checkInfections() {
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

    public void checkBulletHit() {

        for (int i = 0; i < bulletFieldPositions.length; i++) {
            for (int j = 0; j < civilians.length; j++) {
                if (civilians[j].isInfected()) {
                    int col=civilians[j].getFieldPosition().getCol();
                    int row=civilians[j].getFieldPosition().getRow();
                    if (bulletFieldPositions[i].equals(col,row)) {
                        civilians[j].cure();
                        System.out.println("A civilian was cured");
                    }
                }

            }
        }
    }

    public boolean checkInRange(int range, FieldPosition position1, FieldPosition position2) {

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

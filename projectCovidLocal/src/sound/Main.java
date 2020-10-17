package sound;

/**
 * Created by falcao on 01/02/2017.
 */
public class Main {

    public static void main(String[] args) {

        Sound arrow = new Sound("/resources/sound/Arrow2.wav");
        //arrow.play(true);
        arrow.close();

        Sound sneeze = new Sound("/resources/sound/sneeze.wav");
        //sneeze.play(true);
        sneeze.close();
        Sound win = new Sound("/resources/sound/Win.wav");
        win.play(true);
        //win.close();

        Sound gameOver = new Sound("/resources/sound/GameOver.wav");
        //gameOver.setLoop(10);
        //gameOver.play(true);
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        win.close();







    }
}

package multithread;

import java.util.Random;

public class MultiServer {

    public static void main(String[] args) {

        WaitingRoom waitingRoom = new WaitingRoom();

        for (int i = 0; i < 20; i++) {

            Random random = new Random();
            int randomInteger = random.nextInt(2);

            Thread thread;

            if (randomInteger == 0) {
                thread = new Thread(
                        new ServerThread(ServerThread.CAT_IDENTIFIER, waitingRoom)
                );
            } else {
                thread = new Thread(
                        new ServerThread(ServerThread.DOG_IDENTIFIER, waitingRoom)
                );
            }

            thread.start();

        }

    }

}

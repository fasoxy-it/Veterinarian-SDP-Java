package multithread;

public class ServerThread implements Runnable {

    public WaitingRoom waitingRoom;
    public String animalType;
    public static final String CAT_IDENTIFIER = "cat";
    public static final String DOG_IDENTIFIER = "dog";

    public ServerThread(String animalType, WaitingRoom waitingRoom) {
        this.animalType = animalType;
        this.waitingRoom = waitingRoom;
    }

    public void run() {

        try {

            waitingRoom.enterRoom(animalType);
            System.out.println(animalType + " " + Thread.currentThread().getName() + " entered the waiting room!");

            double seconds = 1 + Math.random() * 10;
            Thread.sleep((long) (seconds * 1000));

            waitingRoom.exitRoom(animalType);
            System.out.println(animalType + " " + Thread.currentThread().getName() + " exited the waiting room!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

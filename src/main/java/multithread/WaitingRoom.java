package multithread;

public class WaitingRoom {

    public boolean isCatPresent;
    public int dogCounter = 0;

    public synchronized void enterRoom(String animalType) throws InterruptedException {
        switch (animalType) {
            case ServerThread.CAT_IDENTIFIER:
                while (isCatPresent || dogCounter > 0) {
                    System.out.println("cat " + Thread.currentThread().getName() + " waits...");
                    wait();
                    System.out.println("cat " + Thread.currentThread().getName() + " retries!");
                }
                isCatPresent = true;
            case ServerThread.DOG_IDENTIFIER:
                while (isCatPresent || dogCounter > 3) {
                    System.out.println("dog " + Thread.currentThread().getName() + " waits...");
                    wait();
                    System.out.println("dog " + Thread.currentThread().getName() + " retries!");
                }
                dogCounter++;
        }
    }

    public synchronized void exitRoom(String animalType) {
        switch (animalType) {
            case ServerThread.CAT_IDENTIFIER:
                isCatPresent = false;
                notify();
            case ServerThread.DOG_IDENTIFIER:
                dogCounter--;
                notify();
        }
    }
}

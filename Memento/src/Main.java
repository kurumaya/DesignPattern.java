import game.Memento;
import game.Gamer;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(120);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 30; i++) {
            System.out.println("----- " + i + " -----");
            System.out.println("現状:\t" + gamer.toString());
            gamer.bet();
            System.out.println("試行後:\t" + gamer.toString());

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("## SAVE ##");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("$$ RECOVER $$");
                gamer.restoreFromMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("+++++++++++++ ゲームセット ++++++++++++++");
            }
            System.out.println("");
        }
    }
}
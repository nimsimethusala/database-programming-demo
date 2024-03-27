
package lk.Ijse;

public class WashingMachine {
    private static WashingMachine wm; //1

    private WashingMachine() { //2

    }

    public static WashingMachine getInstance() {   //3
        if(wm == null) {
            wm = new WashingMachine();
        }
        return wm;
    }

    void wash() {
        System.out.println("wash cloths");
    }
}

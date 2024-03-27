package lk.Ijse;

public class Main {
    public static void main(String[] args) {
        /*var wm1 = new WashingMachine();
        var wm2 = new WashingMachine();

        System.out.println("wm1 = " + wm1);
        System.out.println("wm2 = " + wm2);*/

//        new WashingMachine2();  // already WachineMachine2 constructor is private

        WashingMachine wm1 = WashingMachine.getInstance();

        System.out.println("wm1 = " + wm1);
    }
}
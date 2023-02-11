import java.util.Scanner;
import java.time.Instant;
public class Main {

    public static void main(String[] args) {

        Main formula = new Main();
        while(true){
            formula.run();
        }

    }
    public void run(){
        Scanner keyb = new Scanner(System.in);
        System.out.println("Enter name and current SPOT price of the coin \"BTC/USDT 14880\" to buy");
        String spot = keyb.nextLine();
        String[] spotParsed = spot.split(" ");
        System.out.println("Enter p2p price to sell");
        String p2p = keyb.nextLine();

        try{
            double profitable = profit(Double.parseDouble(spotParsed[1]), Double.parseDouble(p2p));
            System.out.println("Your profit in percentages between selling \""+spotParsed[0]+"\" on SPOT and P2P is:");
            System.out.println(profitable+" % at "+Instant.now());
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }
    public double profit(double spot, double p2p){
        double key;
        //key = ((0.75*p2p) - (0.1*spot))/p2p;
        spot =spot+ (spot *0.1/100);
        p2p = p2p - (p2p*0.35/100);
        double temp = p2p-spot;
        key = (temp*100)/p2p;
        return key;
    }


}

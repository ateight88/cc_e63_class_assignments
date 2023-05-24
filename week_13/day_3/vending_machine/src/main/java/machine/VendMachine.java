package machine;

import coins.Coin;
import coins.CoinType;
import products.Product;

import java.util.ArrayList;

public class VendMachine {
    private ArrayList<Drawer> drawers;
    private double credit;
    private CoinReturn coinReturn;

    public VendMachine(ArrayList<Drawer> drawers, double credit, CoinReturn coinReturn) {
        this.drawers = drawers;
        this.credit = credit;
        this.coinReturn = coinReturn;
    }

    public double getCredit() {
        return credit;
    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public boolean checkValidCoins(Coin coin){
        return coin.getType() != CoinType.ONEPENCE && coin.getType() != CoinType.TWOPENCE ;
    }

    public void addCoins(Coin coin){
        if (checkValidCoins(coin)) {
            this.credit += coin.getValue();
        } else {
            this.coinReturn.addCoin(coin);
        }
    }

    public Product sellProducts(KeyCode code){
        for (Drawer drawer : this.drawers ) {
            if(code == drawer.getCode() && this.credit >= drawer.getPrice()) {
                this.credit = 0.0;
                return drawer.sellProduct();
            }
        }
        return null;
    }
}

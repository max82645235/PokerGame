package poker;

/**
 * Created by Administrator on 15-9-9.
 * 牌点数比较算法
 */
public class CompareCardRule {
    public static boolean compareCard(PokerCard card1,PokerCard card2){
        boolean result;
        //先比较点数
        if(card1.getPoint()>card2.getPoint()){
            result = true;
        }else if(card1.getPoint()==card2.getPoint()){
            result = card1.getColor()<card2.getColor();
        }else{
            result = false;
        }

        return result;
    }

}

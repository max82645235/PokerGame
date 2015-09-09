package poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-9-9.
 */
public class Player {
    private String name;//姓名
    private List<PokerCard> cardList;
    public Player(String name) {
        cardList = new ArrayList<PokerCard>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCard(PokerCard card){
        cardList.add(card);
    }


    //获取自身最大点的扑克卡
    public PokerCard getSelfMaxCard(){
        PokerCard maxCard = new PokerCard();
        for(PokerCard card : cardList){
            if(CompareCardRule.compareCard(card, maxCard)){
                maxCard = card;
            }
        }
        return  maxCard;
    }

    public void dropCard(){
        cardList.clear();
    }
}

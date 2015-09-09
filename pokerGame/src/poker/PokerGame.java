package poker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 15-9-9.
 */
public class PokerGame {
    List<PokerCard> allPokerCardList;//所有牌
    List<Player> players;//所有玩家
    int cardIndex=0;//当前指向第几张卡片
    public static void main(String[] args){
        PokerGame pokerGame = new PokerGame();
        pokerGame.init();
        pokerGame.freshCard();
        int playNum = 3;
        for(int i=0;i<playNum;i++){
            pokerGame.publishCard();
            Player winPlayer = pokerGame.getWinPlayer();
            System.out.println("获胜玩家姓名："+winPlayer.getName());
            pokerGame.dropCard();
        }

    }

    //初始化
    public void init(){
        //初始化所有牌
        allPokerCardList = new ArrayList<PokerCard>();
        int[] colorList = {1,2,3,4};
        int[] pointList = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        for(int i=0;i<colorList.length;i++){
            for(int k=0;k<pointList.length;k++){
                allPokerCardList.add(new PokerCard(pointList[k],colorList[i]));
            }
        }

        //初始化玩家
        players = new ArrayList<Player>();
        players.add(new Player("小王"));
        players.add(new Player("小兰"));

    }

    //洗牌
    public void freshCard(){
        Collections.shuffle(allPokerCardList);
    }

    //发牌
    public void publishCard(){
        int pn = 8;//每次发8张卡
        int gcNum = 0;//第几个玩家拿牌
        int endNum = cardIndex+pn;
        for(int i=cardIndex;i<endNum;i++){
            if(cardIndex>allPokerCardList.size()){
                freshCard();
                cardIndex=0;
                System.out.println("-------重新洗牌--------");
            }
            players.get(gcNum).addCard(allPokerCardList.get(cardIndex));//玩家获取最上面一张卡片
            gcNum++;
            cardIndex++;
            if(gcNum==players.size()){
                gcNum = 0;
            }
        }
    }

    //比点
    public Player getWinPlayer(){
        Player winPlayer = new Player("");
        for(Player p :players){
            if(CompareCardRule.compareCard(p.getSelfMaxCard(),winPlayer.getSelfMaxCard())){
                winPlayer = p;
            }
        }
        PokerCard wincard = winPlayer.getSelfMaxCard();
        System.out.println("获胜牌为："+wincard.getCnColor()+wincard.getCnPoint()+"!");
        return  winPlayer;
    }

    //弃牌
    public void dropCard(){
        for(Player p :players){
            p.dropCard();
        }
    }
}

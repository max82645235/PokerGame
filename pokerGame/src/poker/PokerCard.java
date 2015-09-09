package poker;

/**
 * Created by Administrator on 15-9-9.
 *  扑克牌类
 */
public class PokerCard {
    private int color;//花色
    private int point;//点数

    public PokerCard(){}

    public PokerCard(int point, int color) {
        this.point = point;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public int getPoint() {
        return point;
    }

    public String getCnPoint() {
        String cnPoint = "";
        if(point==11){
            cnPoint = "J";
        }else if(point==12){
            cnPoint = "Q";
        }else if(point==13){
            cnPoint = "K";
        }else if(point==14){
            cnPoint = "A";
        }else{
            cnPoint = String.valueOf(point);
        }
        return cnPoint;
    }

    //获取花色名称
    public String getCnColor(){
        String cnColor = "";
        if(color==1){
            cnColor = "黑桃";
        }

        if(color==2){
            cnColor = "红桃";
        }

        if(color==3){
            cnColor = "草花";
        }

        if(color==4){
            cnColor = "方片";
        }
        return  cnColor;
    }
}

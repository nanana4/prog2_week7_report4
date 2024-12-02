package jp.ac.uryukyu.ie.e245724;

/**
 * 勇者（ヒーロー）を表現するクラスです。
 * LivingThingクラスを継承し、死亡時のメッセージをカスタマイズします。
 */
public class Hero extends LivingThing {

    /**
     * コンストラクタ。勇者の名前、HP、攻撃力を設定します。
     * 
     * @param name 勇者の名前
     * @param hitPoint 勇者の最大HP
     * @param attack 勇者の攻撃力
     */
    public Hero(String name, int hitPoint, int attack) {
        super(name, hitPoint, attack);
    }

    /**
     * 勇者がダメージを受けた際のメッセージをオーバーライドします。
     * 
     * @param damage 受けたダメージの量
     */
    @Override
    public void wounded(int damage) {
        super.wounded(damage);
        if (dead) {
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name); // 勇者特有のメッセージ
        }
    }
}

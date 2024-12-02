package jp.ac.uryukyu.ie.e245724;

/**
 * モンスター（敵キャラクター）を表現するクラスです。
 * LivingThingクラスを継承し、死亡時のメッセージをカスタマイズします。
 */
public class Enemy extends LivingThing {

    /**
     * コンストラクタ。モンスターの名前、HP、攻撃力を設定します。
     * 
     * @param name モンスターの名前
     * @param hitPoint モンスターの最大HP
     * @param attack モンスターの攻撃力
     */
    public Enemy(String name, int hitPoint, int attack) {
        super(name, hitPoint, attack);
    }

    /**
     * モンスターがダメージを受けた際のメッセージをオーバーライドします。
     * 
     * @param damage 受けたダメージの量
     */
    @Override
    public void wounded(int damage) {
        super.wounded(damage);
        if (dead) {
            System.out.printf("モンスター%sは倒れた。\n", name); // モンスター特有のメッセージ
        }
    }
}

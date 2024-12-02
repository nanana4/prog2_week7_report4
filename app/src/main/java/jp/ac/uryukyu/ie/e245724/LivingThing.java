package jp.ac.uryukyu.ie.e245724;

/**
 * 生物（キャラクター）を表現する基底クラスです。
 * 名前、HP（ヒットポイント）、攻撃力、死亡状態を管理し、攻撃を行う機能を提供します。
 */
public abstract class LivingThing {

    protected String name;
    protected int hitPoint;
    protected int attack;
    protected boolean dead;

    /**
     * コンストラクタ。名前、HP、攻撃力を設定します。
     *
     * @param name モンスターまたはヒーローの名前
     * @param hitPoint 最大HP
     * @param attack 攻撃力
     */
    public LivingThing(String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    /**
     * 死亡状態を取得するメソッドです。
     *
     * @return 死亡している場合はtrue、それ以外はfalse
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * 名前を取得するためのゲッターです。
     *
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 攻撃を行うメソッドです。攻撃対象のキャラクターにランダムダメージを与えます。
     *
     * @param opponent 攻撃対象のキャラクター
     */
    public void attack(LivingThing opponent) {
        if (dead) {
            System.out.printf("%sは死亡しているため攻撃できません。\n", name);
            return;
        }
        int damage = (int) (Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
        opponent.wounded(damage);
    }

    /**
     * ダメージを受けたときの処理を行います。HPが0以下になると死亡します。
     *
     * @param damage 受けたダメージの量
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);  // 共通のメッセージ
        }
    }

    public int getHitPoint() {
        return this.hitPoint;
    }
    
}

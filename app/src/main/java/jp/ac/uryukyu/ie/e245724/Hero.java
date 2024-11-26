package jp.ac.uryukyu.ie.e245724;

/**
 * 勇者（ヒーロー）を表現するクラスです。
 * 名前、HP（ヒットポイント）、攻撃力、死亡状態を管理し、モンスターに攻撃を行う機能を提供します。
 */
public class Hero {
    
    /**
     * 勇者の名前
     */
    private String name;

    /**
     * 勇者のHP（ヒットポイント）
     */
    private int hitPoint;

    /**
     * 勇者の攻撃力
     */
    private int attack;

    /**
     * 勇者の死亡状態。trueの場合、死亡している。
     */
    private boolean dead;

    /**
     * コンストラクタ。勇者の名前、最大HP、攻撃力を設定します。
     * 
     * @param name 勇者の名前
     * @param maximumHP 勇者の最大HP
     * @param attack 勇者の攻撃力
     */
    public Hero(String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * モンスターに攻撃を行うメソッドです。攻撃力に応じてランダムにダメージを算出し、モンスターにそのダメージを与えます。
     * 
     * @param e 攻撃対象のモンスター
     */
    public void attack(Enemy e) {
        if (dead) {
            System.out.printf("%sは死亡しているため攻撃できません。\n", name);
            return;
        }
        int damage = (int) (Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, e.getName(), damage);
        e.wounded(damage);
    }

    /**
     * 勇者がダメージを受けるメソッドです。ダメージを受けた結果、HPが0以下になると死亡します。
     * 
     * @param damage 受けたダメージの量
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint <= 0) {
            dead = true;
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }

    /**
     * 勇者の名前を取得するためのゲッターです。
     * 
     * @return 勇者の名前
     */
    public String getName() {
        return name;
    }

    /**
     * 勇者のHPを取得するためのゲッターです。
     * 
     * @return 勇者の現在のHP
     */
    public int getHitPoint() {
        return hitPoint;
    }

    /**
     * 勇者のHPを設定するためのセッターです。
     * 
     * @param hitPoint 設定するHP
     */
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    /**
     * 勇者の攻撃力を取得するためのゲッターです。
     * 
     * @return 勇者の攻撃力
     */
    public int getAttack() {
        return attack;
    }

    /**
     * 勇者の死亡状態を取得するためのゲッターです。
     * 
     * @return 勇者が死亡している場合はtrue、それ以外はfalse
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * 勇者の死亡状態を設定するためのセッターです。
     * 
     * @param dead 死亡状態を設定する（trueの場合、死亡）
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }
}

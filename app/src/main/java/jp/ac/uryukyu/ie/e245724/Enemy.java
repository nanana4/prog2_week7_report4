package jp.ac.uryukyu.ie.e245724;

/**
 * モンスター（敵キャラクター）を表現するクラスです。
 * 名前、HP（ヒットポイント）、攻撃力、死亡状態を管理し、ヒーローに攻撃を行う機能を提供します。
 */
public class Enemy {
    
    /**
     * モンスターの名前
     */
    private String name;

    /**
     * モンスターのHP（ヒットポイント）
     */
    private int hitPoint;

    /**
     * モンスターの攻撃力
     */
    private int attack;

    /**
     * モンスターの死亡状態。trueの場合、死亡している。
     */
    private boolean dead;

    /**
     * コンストラクタ。モンスターの名前、最大HP、攻撃力を設定します。
     * 
     * @param name モンスターの名前
     * @param maximumHP モンスターの最大HP
     * @param attack モンスターの攻撃力
     */
    public Enemy(String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * ヒーローに攻撃を行うメソッドです。攻撃力に応じてランダムにダメージを算出し、ヒーローにそのダメージを与えます。
     * 
     * @param hero 攻撃対象のヒーロー
     */
    public void attack(Hero hero) {
        if (dead) {
            System.out.printf("%sは死亡しているため攻撃できません。\n", name);
            return;
        }
        int damage = (int) (Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
        hero.wounded(damage);
    }

    /**
     * モンスターがダメージを受けるメソッドです。ダメージを受けた結果、HPが0以下になると死亡します。
     * 
     * @param damage 受けたダメージの量
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint <= 0) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

    /**
     * モンスターの名前を取得するためのゲッターです。
     * 
     * @return モンスターの名前
     */
    public String getName() {
        return name;
    }

    /**
     * モンスターのHPを取得するためのゲッターです。
     * 
     * @return モンスターの現在のHP
     */
    public int getHitPoint() {
        return hitPoint;
    }

    /**
     * モンスターのHPを設定するためのセッターです。
     * 
     * @param hitPoint 設定するHP
     */
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    /**
     * モンスターの攻撃力を取得するためのゲッターです。
     * 
     * @return モンスターの攻撃力
     */
    public int getAttack() {
        return attack;
    }

    /**
     * モンスターの死亡状態を取得するためのゲッターです。
     * 
     * @return モンスターが死亡している場合はtrue、それ以外はfalse
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * モンスターの死亡状態を設定するためのセッターです。
     * 
     * @param dead 死亡状態を設定する（trueの場合、死亡）
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }
}

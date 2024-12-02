package jp.ac.uryukyu.ie.e245724;

/**
 * 勇者の上位職であるWarriorクラス。
 * Heroを継承し、特別な攻撃メソッドを追加。
 */
public class Warrior extends Hero {

    /**
     * コンストラクタ。Heroクラスのコンストラクタを利用。
     * 
     * @param name      名前
     * @param maximumHP 最大HP
     * @param attack    攻撃力
     */
    public Warrior(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    /**
     * ウェポンスキル攻撃を実行するメソッド。
     * 固定ダメージとして攻撃力の150%を与える。
     * 
     * @param opponent 攻撃対象
     */
    public void attackWithWeponSkill(LivingThing opponent) {
        if (isDead()) {
            System.out.printf("%sは死亡しているため攻撃できません。\n", getName());
            return;
        }
        int damage = (int) (getAttack() * 1.5); // 150%のダメージを計算
        System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
        opponent.wounded(damage);
    }
}

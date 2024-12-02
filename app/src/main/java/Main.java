import jp.ac.uryukyu.ie.e245724.*;

public class Main {
    public static void main(String[] args) {
        Warrior Warrior = new Warrior("戦士", 10, 5);
        Enemy enemy = new Enemy("スライム", 6, 3);

        System.out.printf("%s vs. %s\n", Warrior.getName(), enemy.getName());

        int turn = 0;
        while (!Warrior.isDead() && !enemy.isDead()) {
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            Warrior.attackWithWeponSkill(enemy);
            if (!enemy.isDead()) { // 敵が死んでいない場合のみ攻撃
                enemy.attack(Warrior);
            }
        }
        System.out.println("戦闘終了");
    }
}

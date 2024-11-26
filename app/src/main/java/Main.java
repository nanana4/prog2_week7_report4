import jp.ac.uryukyu.ie.e245724.*;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("勇者", 10, 5);
        Enemy enemy = new Enemy("スライム", 6, 3);

        System.out.printf("%s vs. %s\n", hero.getName(), enemy.getName());

        int turn = 0;
        while (!hero.isDead() && !enemy.isDead()) {
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy);
            if (!enemy.isDead()) { // 敵が死んでいない場合のみ攻撃
                enemy.attack(hero);
            }
        }
        System.out.println("戦闘終了");
    }
}

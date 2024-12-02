package jp.ac.uryukyu.ie.e245724;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    @Test
    void attackWithWeponSkillTest() {
        Warrior warrior = new Warrior("戦士", 100, 20); // 攻撃力20
        Enemy enemy = new Enemy("スライム", 100, 10); // HP100の敵

        // ウェポンスキルを3回実行
        for (int i = 0; i < 3; i++) {
            int expectedDamage = (int) (20 * 1.5); // 150%のダメージ = 30
            int enemyHpBeforeAttack = enemy.getHitPoint();
            warrior.attackWithWeponSkill(enemy);
            int enemyHpAfterAttack = enemy.getHitPoint();

            assertEquals(enemyHpBeforeAttack - expectedDamage, enemyHpAfterAttack,
                "ウェポンスキルのダメージが正しく適用されているはず。");
        }
    }
}

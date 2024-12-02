package jp.ac.uryukyu.ie.e245724;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    /**
     * 倒れたはずの敵は攻撃できないことを検証。
     * 検証手順
     *  (1) ヒーローと敵を準備。ヒーローの攻撃力は敵を一撃で倒せるほど強い状態とする。
     *  (2) ヒーローが殴り、敵も殴る。敵は一撃で倒されていることを期待。
     *  (3) 敵が死んだ状態ならば攻撃できないはず。
     * 　　つまり攻撃実行してもヒーローのHPは減っていないことを期待。これを検証する。
     */
    @Test
    void attackTest() {
        int defaultHeroHp = 100; // ヒーローの初期HP  
        Hero demoHero = new Hero("デモ勇者", defaultHeroHp, 100); // ヒーロー生成
        Enemy slime = new Enemy("スライムもどき", 10, 100); // 敵生成

        demoHero.attack(slime); // ヒーローが敵を攻撃
        assertTrue(slime.isDead(), "スライムは倒れているはず。");

        int heroHpAfterAttack = demoHero.getHitPoint(); // ヒーローの現在HPを取得
        slime.attack(demoHero); // 倒れた敵が攻撃（無効のはず）
        assertEquals(heroHpAfterAttack, demoHero.getHitPoint(), "倒れた敵は攻撃できないはず。");
    }
}
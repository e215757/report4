package jp.ac.uryukyu.ie.e215757;

public class LivingThing {
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名
     * @param maximumHP HP
     * @param attack s攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * メンバ変数「dead」を取得するメソッド
     * @return　取得したいdead
     */
    public boolean isDead() {
        return this.dead;
    }

    /**
     * メンバ変数「name」を取得するメソッド
     * @return　取得したいname
     */
    public String getName(){
        return this.name;
    }

    /**
     * メンバ変数「hitPoint」を取得するメソッド
     * @return　取得したいhitPoint
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * deadを変更するとき使用
     * @param 設定するdead
     */
    public void setDead(String _dead){
        this.name = _dead;
    }

    /**
     * nameを変更する時使用
     * @param 設定するname
     */
    public void setName(String _name){
        this.name = _name;
    }

    /**
     * hitPointを変更する時使用
     * @param 設定するhitPoint
     */
    public void setHitPoint(int _hitPoint){
        this.hitPoint = _hitPoint;
    }

    /**
     * 相手へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(LivingThing opponent){
        int damage = (int)(Math.random() * attack);
        if( !dead ){
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    
    
}
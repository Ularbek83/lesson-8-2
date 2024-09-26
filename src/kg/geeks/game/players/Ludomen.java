package kg.geeks.game.players;

import java.util.Random;

public class Ludomen extends Hero {

    private int bond1 = 0;
    private int bond2 = 0;
    private Hero[] heroes;

    public Ludomen(int health, int damage, String name
    ) {
        super(health, damage, name, SuperAbility.NONE);
        bond1 = getRollBone();
        bond2 = getRollBone();
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }

    @Override
    public void attack(Boss boss) {
        if (bond1 == bond2) {
            System.out.println(this.getName() + " attacked boss health: " + boss.getHealth());
            boss.setHealth(boss.getHealth() - (bond1 * bond2));
        } else {
            Hero hero = null;
            boolean isHeroFound = false;
            do {
                hero = getRandomHero();
                if (!this.getName().equals(hero.getName())) {
                    isHeroFound = true;
                }
            } while (!isHeroFound);

            System.out.println(this.getName() + " attacked " + hero.getName() + " health " + hero.getHealth());
            hero.setHealth(hero.getHealth() - this.getDamage());
        }
    }

    public int getRollBone() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public Hero getRandomHero() {
        Random rand = new Random();
        int heroIndex = rand.nextInt(this.heroes.length);
        return this.heroes[heroIndex];
    }

    public void setHeroes(Hero[] heroes){
        this.heroes = heroes;
    }
}



package com.example.coding_test.cotestates;

import java.util.Scanner;

public class text_starcraft {
    public static void main(String[] args) {
        System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
        System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
        Unit unit1 = createUnit();

        System.out.println("[안내] 상대의 유닛 정보를 입력해 주세요.");
        Unit unit2 = createUnit();

        while(unit2.hp > 0) {
            unit1.attack(unit2);
        }
    }

    public static Unit createUnit() {
        String name;
        int power;
        int defence;
        int hp;

        Scanner sc = new Scanner(System.in);
        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 : ");
        name = sc.next();
        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : ");
        power = sc.nextInt();
        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : ");
        defence = sc.nextInt();
        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : ");
        hp = sc.nextInt();
        Unit unit = new Unit(name, power, defence, hp);

        return unit;
    }

    static class Unit{
        String name;
        int power;
        int defence;
        int hp;

        void attack(Unit target) {
            target.hp -= this.power;
            System.out.println("---------------------------------------------------");
            System.out.println("[안내] [" + this.name + "]유닛이 [공격] 하였습니다.");
            System.out.println("[안내] 상대 유닛의 남은 [체력]은 " +target.hp+ " 입니다.");

            if (target.hp <= 0) {
                System.out.println("---------------------------------------------------");
                System.out.println("[안내] 더 이상 공격할 수 없습니다.");
                System.out.println("\n[안내] 상대 유닛이 제거되었습니다.");
            }
        }

        public Unit(String name, int power, int defence, int hp) {
            this.name = name;
            this.power = power;
            this.defence = defence;
            this.hp = hp;

            System.out.println("\n[안내] 생성된 유닛 정보는 다음과 같습니다.");
            System.out.println("[안내] " + this.name + " 유닛이 게임에 참여하였습니다.");
            System.out.println("[공격력] : " + this.power);
            System.out.println("[방어력] : " + this.defence);
            System.out.println("[체력] : " + this.hp);
            System.out.println("======================================================");
        }

        @Override
        public String toString() {
            return "Unit{" +
                    "name='" + name + '\'' +
                    ", power=" + power +
                    ", defence=" + defence +
                    ", hp=" + hp +
                    '}';
        }
    }
}



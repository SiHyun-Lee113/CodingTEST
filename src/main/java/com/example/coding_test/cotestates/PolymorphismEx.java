package com.example.coding_test.cotestates;

public class PolymorphismEx {
    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.buyCoffee(new Americano());
        customer.buyCoffee(new CaffeLatte());

        System.out.println("현재 잔액은 " + customer.money + "원 입니다.");
    }

    static class Coffee {
        int price;

        public Coffee(int price) {
            this.price = price;
        }
    }

    static class Americano extends Coffee {
        public Americano() {
            super(4000);
        }

        @Override
        public String toString() {
            return "Americano";
        }
    }
    static class CaffeLatte extends Coffee {
        public CaffeLatte() {
            super(5000);
        }

        @Override
        public String toString() {
            return "CaffeLatte";
        }
    }

    static class Customer {
        int money = 50000;

        void buyCoffee(Coffee coffee) {
            if(money < coffee.price) {
                System.out.println("잔액이 부족합니다.");
                return;
            }
            money -= coffee.price;
            System.out.println(coffee + "를 구매했습니다.");
        }
    }
}

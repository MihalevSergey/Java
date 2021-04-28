package Lesson1.HW.Animal;

import Lesson1.HW.Competitor;

public class Animal implements Competitor {
    String type;
    String name;

    int maxRunDistance;
    int maxJumpDistance;
    int maxSwimDistance;

    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Animal(String type, String name, int maxRunDistance, int maxJumpDistance, int maxSwimDistance) {
    this.name = name;
    this.type = type;
    this.maxRunDistance = maxRunDistance;
    this.maxJumpDistance = maxJumpDistance;
    this.maxSwimDistance = maxSwimDistance;
    this.onDistance = true;
    }

    @Override
    public void run(int dist){
        if(maxRunDistance >= dist){
            System.out.println(type + " " + name + " успешно прошел(а) кросс");
        } else {
            System.out.println(type + " " + name + " кросс не пройден");
            onDistance = false;
        }

    }

    @Override
    public void jump(int height){
        if(maxJumpDistance > height){
            System.out.println(type + " " + name + " успешно перепрыгнул(а) препятсвие");
        } else {
            System.out.println(type + " " + name + " препятсвие не преодолено");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist){
        if(maxSwimDistance >= dist){
            System.out.println(type + " " + name + " успешно переплыл(а) реку");

        } else {
            System.out.println(type + " " + name + " реку не переплыл(а)");
            onDistance = false;
        }
    }

    @Override
    public void info(){
        System.out.println(type + " " + name + " — " + onDistance);
    }


    @Override
    public void infoTeam() {
        System.out.println(type + " " + name);
    }

    }


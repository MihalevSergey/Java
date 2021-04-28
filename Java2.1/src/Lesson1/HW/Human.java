
package Lesson1.HW;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxJumpDistance;
    int maxSwimDistance;

    boolean isActive;

    @Override
    public boolean isOnDistance() {
        return isActive;
    }

    public Human (String name) {
        this.name = name;
        this.maxJumpDistance = 6;
        this.maxRunDistance = 1000;
        this.maxSwimDistance = 200;
        this.isActive = true;
    }

    @Override
    public void run(int dist){
        if (maxRunDistance >= dist){
            System.out.println(name + " успешно прошел(а) кросс");
            } else {
            System.out.println(name + " кросс не прошла");
            isActive = false;
        }
    }

    public void jump(int height){
        if (maxJumpDistance > height){
            System.out.println(name + " успешно перепрыгнул(а) стену");
        } else {
            System.out.println(name + " стену не перепрыгнул(а)");
        }
        isActive = false;
    }

    public void swim(int dist){
        if (maxSwimDistance > dist){
            System.out.println(name + " успешно переплыл(а) реку");
        } else {
            System.out.println(name + " реку не переплыл(а)");
        }
        isActive = false;
    }

    @Override
    public void info(){
        System.out.println(name + " " + isActive);
    }

    @Override
    public void infoTeam(){
        System.out.println(name);
    }
}

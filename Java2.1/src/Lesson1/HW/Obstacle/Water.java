package Lesson1.HW.Obstacle;

import Lesson1.HW.Competitor;

public class Water extends Obstacle{
    int length;

    public Water(int length){
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor){
        competitor.swim(length);
    }
}

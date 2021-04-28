package Lesson1.HW.Obstacle;

import Lesson1.HW.Competitor;

public class Cross extends Obstacle{
    int lenght;

    public Cross (int lenght){
        this.lenght = lenght;
    }

    @Override
    public void doIt(Competitor competitor){
        competitor.run(lenght);
    }
}

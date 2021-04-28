package Lesson1.HW.Obstacle;

import Lesson1.HW.Team;
import Lesson1.HW.Competitor;

public class Course {
    private Obstacle[] course;

    public Course(Obstacle... course){
        this.course = course;

    }

    public void doIt(Team team){
        for (Competitor c: team.getSquad()){
            for (Obstacle o: course){
                if(!c.isOnDistance());
                break;
            }
        }


    }

}

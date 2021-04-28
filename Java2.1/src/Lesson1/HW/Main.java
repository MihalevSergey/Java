package Lesson1.HW;

import Lesson1.HW.Animal.Cat;
import Lesson1.HW.Animal.Dog;
import Lesson1.HW.Obstacle.Course;
import Lesson1.HW.Obstacle.Cross;
import Lesson1.HW.Obstacle.Wall;
import Lesson1.HW.Obstacle.Water;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(new Wall(5), new Cross(100), new Water(1), new Cross(200));
        Team team = new Team("Герои", new Cat("Васька"), new Dog("Бврсик"));
        Team team1 = new Team("Злодеи", new Dog("Шарик"), new Human("Alex"));
        course.doIt(team);
        course.doIt(team1);
        team.showInfo();
        team1.showInfo();
        team.showWinnerTeam();
        team1.showWinnerTeam();

    }
}

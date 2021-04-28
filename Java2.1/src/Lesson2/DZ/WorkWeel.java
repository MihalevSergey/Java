package Lesson2.DZ;

enum DayOfWeek {
    MONDAY("понедельник", 0), TUESDAY("вторник", 8),
    EDNESDAY("среда", 16), THURSDAY("четрвег", 24), FRIDAY("пятница", 32);

    String day;
    int hours;


    DayOfWeek(String day, int hours) {
        this.day = day;
        this.hours = hours;
    }

    String gatDay() {
        return day;
    }

    int getHours() {
        return hours;
    }

    void setDay(String day) {
        this.day = day;
    }

    void setHours(int hours) {
        this.hours = hours;
    }


}


public class WorkWeel {

    public static int hoursToEndOfWeek(String s) {
        int hoursToEnd = 0;
        for (DayOfWeek d : DayOfWeek.values()) {
            if (d.gatDay().equals(s.toLowerCase())) {
                hoursToEnd = 40 - d.getHours();
            }
        }
        return hoursToEnd;
    }

    public static void main(String[] args){
       System.out.println(hoursToEndOfWeek("Вторник"));
        //System.out.println(DayOfWeek.valueOf("MONDAY").getHours());

    }

}


package com.guild.schedule.MagicCourseTest;

import com.guild.schedule.MagicCourse.MagicCourse;
import java.util.*;

public class MagicCourseTest {
    public static void main(String[] args) {
        MagicCourse c1 = new MagicCourse();
        MagicCourse c2 = new MagicCourse("Fire Magic", "Monday", 9, 11);
        MagicCourse c3 = new MagicCourse("Frost Spell", "Tuesday", 10, 12);
        MagicCourse c4 = new MagicCourse("Summoning", "Tuesday", 11, 13);
        MagicCourse c5 = new MagicCourse("Healing", "Wednesday", 8, 10);

        // Invalid Input Test
        c1.setCourseName("");// empty
        c1.setCourseName(null);// null
        c1.setStartTime(-5);// negative values
        c1.setStartTime(30);// exceeding max hour
        c1.setEndTime(25);// exceeding max hour
        c1.setEndTime(-5);// negative values

        // 我好像做错很多，需要改，明天再噶有。。。。。。。sumimasen。。。

        // Course Conflict Test
        System.out.println("Overlapping status: " + MagicCourse.hasConflict(c3, c4));
        System.out.println("Total Courses: " + MagicCourse.getTotalCourses());
    }
}

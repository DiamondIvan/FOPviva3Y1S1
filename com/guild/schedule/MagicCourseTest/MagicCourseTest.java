package com.guild.schedule.MagicCourseTest;

import com.guild.schedule.MagicCourse.MagicCourse;
import java.util.*;

public class MagicCourseTest {
    public static void main(String[] args) {
        //1. Object Creation Test
        
        MagicCourse c1 = new MagicCourse("Healing", "Wednesday", 8, 10);
        MagicCourse c2 = new MagicCourse("Fire Magic", "Monday", 9, 11);
        MagicCourse c3 = new MagicCourse("Frost Spell", "Tuesday", 10, 12);
        MagicCourse c4 = new MagicCourse("Summoning", "Tuesday", 11, 13);
        MagicCourse c5 = new MagicCourse();
        

        //2. Invalid Input Tests (expect exceptions)
        try { c1.setCourseName(""); } catch (IllegalArgumentException e) { System.out.println("setCourseName empty: " + e.getMessage()); }
        try { c1.setStartTime(-5); } catch (IllegalArgumentException e) { System.out.println("setStartTime -5: " + e.getMessage()); }
        try { c1.setStartTime(30); } catch (IllegalArgumentException e) { System.out.println("setStartTime 30: " + e.getMessage()); }
        try { c1.setEndTime(25); } catch (IllegalArgumentException e) { System.out.println("setEndTime 25: " + e.getMessage()); }
        try { c1.setEndTime(-5); } catch (IllegalArgumentException e) { System.out.println("setEndTime -5: " + e.getMessage()); }

        //3. Course Conflict Test
        System.out.println("Overlap c3/c4 (expected true): " + MagicCourse.hasConflict(c3, c4));
        System.out.println("Overlap c1/c2 (expected false): " + MagicCourse.hasConflict(c1, c2));
        try {
            MagicCourse.hasConflict(c1, c5);
        } catch (IllegalArgumentException e) {
            System.out.println("Overlap with null times throws: " + e.getMessage());
        }

        // 4. Conflict Count Test
        List<MagicCourse> courses = new ArrayList<>();
        courses.add(c1); // Healing, Wednesday 8-10
        courses.add(c2); // Fire Magic, Monday 9-11
        courses.add(c3); // Frost Spell, Tuesday 10-12
        courses.add(c4); // Summoning, Tuesday 11-13

        Integer conflictCount = MagicCourse.countConflicts(courses);
        System.out.println("Conflict count (expected 1): " + conflictCount);

        // Empty list should return null
        List<MagicCourse> empty = new ArrayList<>();
        System.out.println("Empty list conflict count (expected null): " + MagicCourse.countConflicts(empty));

        
       

        

        //5. Total Course Count Test
        System.out.println("Total Courses: " + MagicCourse.getTotalCourses());
    }
}

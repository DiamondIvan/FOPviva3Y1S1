package com.guild.schedule.MagicCourse;

import java.util.*;

public class MagicCourse {

    private String courseName;// cannot be null
    private String dayOfWeek;// e.g. Monday
    private Integer startTime;// 24-hour format
    private Integer endTime;// must be later than startTime
    // Integer allows this to be 'null' initially

    // Static variables belong to the Class, not the objects
    private static final int MAX_HOUR = 24;
    private static int totalCourses = 0;// Increments every time 'new MagicCourse()' is called

    // NO-ARG CONSTRUCTOR
    // Used when creating a "placeholder" course.
    public MagicCourse() {
        this.courseName = "Unnamed Magic Course";
        this.dayOfWeek = "Not Set";
        this.startTime = null;
        this.endTime = null;
        totalCourses++;
    }

    // PARAMETERIZED CONSTRUCTOR
    // Used when we know all the details upfront.
    public MagicCourse(String courseName, String dayOfWeek, Integer startTime, Integer endTime) {

        // Validation
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty");
        } else if (startTime < 0 || startTime > MAX_HOUR || endTime < 0 || endTime > MAX_HOUR) {
            throw new IllegalArgumentException("Time out of valid range");
        } else if (startTime >= endTime) {
            throw new IllegalArgumentException("Course end time must be later than start time");
        } else {
            this.courseName = courseName.trim();
            this.dayOfWeek = dayOfWeek.trim();
            this.startTime = startTime;
            this.endTime = endTime;

            totalCourses++;
        }
    }

    // ENCAPSULATION METHODS

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty())
            throw new IllegalArgumentException("Course name cannot be empty");
        else
            this.courseName = courseName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        if (dayOfWeek == null || dayOfWeek.trim().isEmpty()){
            throw new IllegalArgumentException("Day of week cannot be empty");
        }
        else if (this.endTime != null && startTime >= this.endTime) {
            throw new IllegalArgumentException("Start time must be before end time");
        } else
            this.dayOfWeek = dayOfWeek;
    }

    public void setStartTime(Integer startTime) {
        // Validation for the 0-2400 range
        if (startTime < 0 || startTime > MAX_HOUR) {
            throw new IllegalArgumentException("Start time out of range");
        } else {
            this.startTime = startTime;
        }

    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setEndTime(Integer endTime) {
        // Validation

        if (endTime < 0 || endTime > MAX_HOUR) {
            throw new IllegalArgumentException("End time out of range");
        } else if (this.startTime != null && endTime <= this.startTime) {
            throw new IllegalArgumentException("End time must be after start time");
        } else {
            this.endTime = endTime;
        }

    }

    public Integer getEndTime() {
        return endTime;
    }

    public static int getTotalCourses() {
        return totalCourses;
    }

    // STATIC CLASS METHODS
    // hasConflict() compares two courses to see if they overlap
    public static boolean hasConflict(MagicCourse c1, MagicCourse c2) {
        if (c1.startTime == null || c1.endTime == null || c2.startTime == null || c2.endTime == null) {
            throw new IllegalArgumentException("Course time cannot be null");
        }
        // Check if they are on the same day (ignoring capitalization)
        // Times must overlap: C1 starts before C2 ends AND C1 ends after C2 starts
        if (c1.dayOfWeek.equalsIgnoreCase(c2.dayOfWeek) &&
                (c1.startTime < c2.endTime && c1.endTime > c2.startTime)) {
            return true;
        } else {
            return false;
        }
    }

    // countConflicts walks through the List (courseList) using nested loops.
    // It compares every course to every other course exactly once.
    public static Integer countConflicts(List<MagicCourse> courseList) {
        if (courseList == null || courseList.isEmpty()) {
            return null;
        }

        int conflictCount = 0;

        // Compare each course (i) with every subsequent course (j) to avoid
        // double-counting

        // i loop picks a course
        for (int i = 0; i < courseList.size() - 1; i++) {
            // j loop picks the next courses in the list
            for (int j = i + 1; j < courseList.size(); j++) {
                if (hasConflict(courseList.get(i), courseList.get(j))) {
                    conflictCount++;
                }
            }
        }
        return conflictCount;
    }

}

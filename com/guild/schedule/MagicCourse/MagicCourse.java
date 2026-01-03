package com.guild.schedule.MagicCourse;

import java.util.*;

public class MagicCourse {
    private String courseName;// cannot be null
    private String dayOfWeek;// e.g. Monday
    private Integer startTime;// 24-hour format
    private Integer endTime;// must be later than startTime

    private static final int MAX_HOUR = 2400;
    private static int totalCourses = 0;

    public MagicCourse() {
        this.courseName = "Unnamed Magic Course";
        this.dayOfWeek = "Not Set";
        this.startTime = null;
        this.endTime = null;
        totalCourses++;
    }

    public MagicCourse(String courseName, String dayOfWeek, Integer startTime, Integer endTime) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty");
        } else if (startTime < 0 || startTime > MAX_HOUR || endTime < 0 || endTime > MAX_HOUR) {
            throw new IllegalArgumentException("Time out of valid range");
        } else if (startTime >= endTime) {
            throw new IllegalArgumentException("Course end time must be later than start time");
        } else {
            this.courseName = courseName;
            this.dayOfWeek = dayOfWeek;
            this.startTime = startTime;
            this.endTime = endTime;

            totalCourses++;
        }
    }

    public String getCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty())
            throw new IllegalArgumentException("Course name cannot be empty");
        else
            return courseName;
    }

    public void setCourseName(String courseName) {
        if (startTime >= endTime)
            throw new IllegalArgumentException("Course end time must be later than start time");
        else
            this.courseName = courseName;
    }

    public String getDayOfWeek(String dayOfWeek) {
        if (startTime < 0 || startTime > MAX_HOUR || endTime < 0 || endTime > MAX_HOUR)
            throw new IllegalArgumentException("Time out of valid range");
        else
            return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getStartTime(Integer startTime) {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime(Integer endTime) {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public static int getTotalCourses() {
        return totalCourses;
    }

    public static boolean hasConflict(MagicCourse c1, MagicCourse c2) {
        if (c1.startTime == null || c1.endTime == null || c2.startTime == null || c2.endTime == null) {
            throw new IllegalArgumentException("Course time cannot be null");
        }
        if (c1.dayOfWeek.equals(c2.dayOfWeek) &&
                (c1.startTime < c2.endTime && c1.endTime > c2.startTime)) {
            return true;
        } else {
            return false;
        }
    }

    public static Integer countConflicts(List<MagicCourse> courseList) {
        if (courseList == null || courseList.isEmpty()) {
            return null;
        }
        int conflictCount = 0;
        for (int i = 0; i < courseList.size() - 1; i++) {
            for (int j = i + 1; j < courseList.size(); j++) {
                if (hasConflict(courseList.get(i), courseList.get(j))) {
                    conflictCount++;
                }
            }
        }
        return conflictCount;
    }

}

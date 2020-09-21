package com.bosch.courses.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bosch.courses.bean.Course;


@Component
public class CourseDetailsService {

    public enum Status {
        SUCCESS, FILAURE;
    }

    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "Course1_Name", "Course1_Description"));
        courses.add(new Course(2, "Course2_Name", "Course2_Description"));
        courses.add(new Course(3, "Course3_Name", "Course3_Description"));
        courses.add(new Course(4, "Course4_Name", "Course4_Description"));
        courses.add(new Course(5, "Course5_Name", "Course5_Description"));
    }

    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public List findAll() {
        return courses;
    }

    public Status deleteById(int id) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId() == id) {
                iterator.remove();
                return Status.SUCCESS;
            }
        }
        return Status.FILAURE;
    }


}

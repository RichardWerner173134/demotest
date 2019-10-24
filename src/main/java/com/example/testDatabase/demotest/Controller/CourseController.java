package com.example.testDatabase.demotest.Controller;

import com.example.testDatabase.demotest.Entities.Course;
import com.example.testDatabase.demotest.Entities.Student;
import com.example.testDatabase.demotest.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    private List<Course> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    private Optional<Course> getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @PostMapping("")
    private void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @DeleteMapping("/{id}")
    private void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }

    @GetMapping("/{courseId}/students")
    private List<Student> getCourseMembers(@PathVariable String courseId) throws Exception {
        return courseService.getCourseMembers(courseId);
    }
}

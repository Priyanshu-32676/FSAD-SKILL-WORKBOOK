package com.klef.exp7.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.exp7.model.Course;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	
	List<Course> courseList = new ArrayList<>();

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        courseList.add(course);
        return new ResponseEntity<>("Course Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/viewCourses")
    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {

        for(Course c : courseList){
            if(c.getCourseId()==id){
                return new ResponseEntity<>(c,HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Course Not Found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,@RequestBody Course course){

        for(Course c: courseList){
            if(c.getCourseId()==id){

                c.setTitle(course.getTitle());
                c.setDuration(course.getDuration());
                c.setFee(course.getFee());

                return new ResponseEntity<>("Course Updated Successfully",HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Course Not Found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){

        Iterator<Course> itr = courseList.iterator();

        while(itr.hasNext()){
            Course c = itr.next();

            if(c.getCourseId()==id){
                itr.remove();
                return new ResponseEntity<>("Course Deleted Successfully",HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Course Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title){

        List<Course> result = new ArrayList<>();

        for(Course c: courseList){
            if(c.getTitle().equalsIgnoreCase(title)){
                result.add(c);
            }
        }

        if(result.isEmpty()){
            return new ResponseEntity<>("No Course Found",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}

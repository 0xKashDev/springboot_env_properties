package kashdev.understandproperties.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
// `*` takes all annotations


@RestController
public class RestEndpoints {

    //injecting properties
    @Value("${default.course.name}")
    private String cName;
    @Value("${default.course.chapterCount}")
    private int cchapterCount;
    @RequestMapping("/defaultCourse")
    public Course getDefaultCourse(@RequestParam(value="name", defaultValue = "Sprint Boot", required = false) String name,
                              @RequestParam(value="chapterCount", defaultValue = "2", required = false) int chapterCount){
        return new Course(cName,cchapterCount);
    }

    @RequestMapping("/course")
    public Course getEndpoint(@RequestParam(value="name", defaultValue = "Sprint Boot", required = false) String name,
                              @RequestParam(value="chapterCount", defaultValue = "2", required = false) int chapterCount){
        return new Course(name,chapterCount);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/course")
    public String saveCourse(@RequestBody Course course){
        return "Your course named " + course.getName() + " with " + course.getChapterCount() + " chapters saved successfully.";
    }
}

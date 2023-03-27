package org.example.controller;

import org.example.model.Teacher;
import org.example.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
     @Autowired
     TeacherServiceImpl service;

     @RequestMapping("/insertSingle")
     @ResponseBody
     void insertSingle(@RequestBody Teacher teacher){
         service.insertSingle(teacher);
     }
     @RequestMapping("/insertMultiple")
     @ResponseBody
     void insertMultiple(@RequestBody List<Teacher> teacherList){
          service.insertMultiple(teacherList);
     }
     @RequestMapping("/selectSingle")
     @ResponseBody
     Teacher selectSingle(@RequestParam int id,@RequestParam int rollNo){
         return service.selectSingle(id,rollNo);
     }
     @RequestMapping("/selectMultiple")
     @ResponseBody
     List<Teacher> selectMultiple(@RequestParam List<Integer> ids,@RequestParam List<Integer> rollNos){
         return service.selectMultiple(ids,rollNos);
     }
     @RequestMapping("/selectAll")
     @ResponseBody
     List<Teacher> selectAll(){
         return service.selectAll();
     }
     @RequestMapping("/updateSingle")
     @ResponseBody
     Teacher updateSingle(@RequestBody Teacher teacher){
        return service.updateSingle(teacher);
     }
     @RequestMapping("/updateMultiple")
     @ResponseBody
     List<Teacher> updateMultiple(@RequestBody List<Teacher> teacherList){
          return service.updateMultiple(teacherList);
     }
     @RequestMapping("/deleteSingle")
     @ResponseBody
     boolean deleteSingle(@RequestParam int id,int rollNo){
        return service.deleteSingle(id, rollNo);
     }
     @RequestMapping("/deleteMultiple")
     @ResponseBody
     List<Boolean> deleteMultiple(@RequestParam List<Integer> ids,@RequestParam List<Integer> rollNos){
          return service.deleteMultiple(ids, rollNos);
     }
     @RequestMapping("/deleteAll")
     @ResponseBody
     boolean deleteAll(){
          return service.deleteAll();
     }
}

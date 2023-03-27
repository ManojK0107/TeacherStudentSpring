package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repo.TeacherRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherServiceImpl{
    @Autowired
    TeacherRepoImpl repo;

    @Override
    public void insertSingle(Teacher teacher){
        repo.insertSingle(teacher);
    }
    @Override
    public void insertMultiple(List<Teacher> teacherList){
        for (int i=0;i<teacherList.size();i++){
            repo.insertSingle(teacherList.get(i));
        }
    }
    @Override
    public Teacher selectSingle(int id,int rollNo){
       return repo.selectSingle(id,rollNo);
    }
    @Override
    public List<Teacher> selectMultiple(List<Integer> ids,List<Integer> rollNos){
        List<Teacher> teacherList=new ArrayList<>();
        for (int i=0;i<ids.size();i++){
            teacherList.add(repo.selectSingle(ids.get(i),rollNos.get(i)));
        }
        return teacherList;
    }
    @Override
    public List<Teacher> selectAll(){
        return repo.selectAll();
    }
    @Override
    public Teacher updateSingle(Teacher teacher){
        return repo.updateSingle(teacher);
    }
    @Override
    public List<Teacher> updateMultiple(List<Teacher> teacherList){
        for (int i=0;i<teacherList.size();i++){
            repo.updateSingle(teacherList.get(i));
        }
        return teacherList;
    }
    @Override
    public boolean deleteSingle(int id, int rollNo){
        return repo.deleteSingle(id, rollNo);
    }
    @Override
    public List<Boolean> deleteMultiple(List<Integer> ids,List<Integer> rollNos){
        List<Boolean> booleanList=new ArrayList<>();
        for (int i=0;i<ids.size();i++){
            booleanList.add(repo.deleteSingle(ids.get(i),rollNos.get(i)));
        }
        return booleanList;
    }
    @Override
    public boolean deleteAll(){
       return repo.deleteAll();
    }

}

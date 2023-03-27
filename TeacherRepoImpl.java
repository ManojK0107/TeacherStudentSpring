package org.example.repo;

import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeacherRepoImpl {
    void insertSingle(Teacher teacher);
    Teacher selectSingle(int id,int rollNo);
    List<Teacher> selectAll();
    Teacher updateSingle(Teacher teacher);
    boolean deleteSingle(int id, int rollNo);
    boolean deleteAll();
}

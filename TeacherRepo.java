package org.example.repo;

import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepo implements TeacherRepoImpl{
    @Override
    public void insertSingle(Teacher teacher){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
            Statement stmt= con.createStatement();
            stmt.executeUpdate("insert into student values('"+teacher.getStudent().getRollNo()+"','"+teacher.getStudent().getName()+"','"+teacher.getStudent().getEmail()+"')");
            stmt.executeUpdate("insert into teacher values('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getEmail()+"')");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Teacher selectSingle(int id,int rollNo){
        Teacher teacher=new Teacher();
        Student student=new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from teacher where id='"+id+"'");
            while (rs.next()){
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setEmail(rs.getString(3));
            }
            ResultSet rs1=stmt.executeQuery("select * from student where rollNo='"+rollNo+"'");
            while (rs1.next()){
                student.setRollNo(rs1.getInt(1));
                student.setName(rs1.getString(2));
                student.setEmail(rs1.getString(3));
            }
            teacher.setStudent(student);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return teacher;
    }
    @Override
    public List<Teacher> selectAll(){
        List<Teacher> teacherList=new ArrayList<>();
        List<Student> studentList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from teacher");
            while (rs.next()){
                Teacher teacher=new Teacher();
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setEmail(rs.getString(3));
                teacherList.add(teacher);
            }
            ResultSet rs1=stmt.executeQuery("select * from student");
            while (rs1.next()){
                Student student=new Student();
                student.setRollNo(rs1.getInt(1));
                student.setName(rs1.getString(2));
                student.setEmail(rs1.getString(3));
                studentList.add(student);
            }
            for (int i=0;i<teacherList.size();i++){
                Teacher t1=teacherList.get(i);
                t1.setStudent(studentList.get(i));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return teacherList;
    }
    @Override
    public Teacher updateSingle(Teacher teacher){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
            Statement stmt= con.createStatement();
            stmt.executeUpdate("update student set name='"+teacher.getStudent().getName()+"',email='"+teacher.getStudent().getEmail()+"' where rollNo='"+teacher.getStudent().getRollNo()+"'");
            stmt.executeUpdate("update teacher set name='"+teacher.getName()+"',email='"+teacher.getEmail()+"' where id='"+teacher.getId()+"'");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return teacher;
    }
    @Override
    public boolean deleteSingle(int id, int rollNo){
        boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
            Statement stmt= con.createStatement();
            int count=stmt.executeUpdate("delete from student where rollNo='"+rollNo+"'");
            int count1=stmt.executeUpdate("delete from teacher where id='"+id+"'");
            if (count>0 && count1>0){
                result=true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public boolean deleteAll(){
        boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
            Statement stmt= con.createStatement();
            int count=stmt.executeUpdate("delete from student");
            int count1=stmt.executeUpdate("delete from teacher");
            if (count>0 && count1>0){
                result=true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}

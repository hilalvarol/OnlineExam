package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdminController {
    private StudentService studentService;
    private UserService userService;
    private ExamService examService;
    private SubjectService subjectService;
    private ScoreService scoreService;
    private QuestionService questionService;
    private AnswerService answerService;

    public AdminController(StudentService studentService, UserService userService, QuestionService questionService,
                          AnswerService answerService, ExamService examService, SubjectService subjectService, ScoreService scoreService) {
        this.studentService = studentService;
        this.userService = userService;
        this.examService = examService;
        this.subjectService = subjectService;
        this.scoreService = scoreService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @RequestMapping("/admin")
    public String adminPanel(HttpServletRequest request) {
         User user = (User) request.getSession().getAttribute("user");
         if (user!=null && user.getRole().equals("admin"))
        return "admin";
         return "redirect:/";
    }

    @RequestMapping("/students")
    public String student(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getRole().equals("admin"))
            return "redirect:/";
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "panelStudent";
    }

    @RequestMapping("/subjects")
    public String subject(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getRole().equals("admin"))
            return "redirect:/";
        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        return "panelSubject";
    }

    @RequestMapping("/subject/add")
    public String addNewSubject(@ModelAttribute("subject") Subject subject, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getRole().equals("admin"))
            return "redirect:/";
        int total = subjectService.findAll().size();
        String subjectId = "123" + total;
        if (subject.getName() != null) {
            subjectService.saveSubject(new Subject(subjectId, subject.getName()));
            return "redirect:/subjects";
        }
        return "addNewSubject";
    }


    @RequestMapping("/subject/edit/{id}")
    public String editSubject(@PathVariable String id, HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getRole().equals("admin"))
            return "redirect:/";
        try {
            Subject subject = subjectService.findById(id);
            model.addAttribute("subject", subject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "updateSubject";
    }

    @RequestMapping("/subject/update/{id}")
    public String updateSubject(@PathVariable String id, @ModelAttribute("subject") Subject subject, HttpServletRequest request) {
        Subject updateSubject = subjectService.findById(id);
        if (subject.getName() != null) {
            updateSubject.setName(subject.getName());
            subjectService.updateSubject(updateSubject);
            return "redirect:/subjects";
        }
        return "updateSubject";
    }

    @RequestMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable String id) {
        try {
            subjectService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/subjects";
    }


    @RequestMapping("/users")
    public String user(Model model, HttpServletRequest request) {
         User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getRole().equals("admin"))
            return "redirect:/";
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "panelUser";
    }


    @RequestMapping("/user/add")
    public String addNewUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        User user1 = (User) request.getSession().getAttribute("user");
        if (user1 == null || !user1.getRole().equals("admin"))
            return "redirect:/";
        int total = userService.findAll().size();
        String role = request.getParameter("userRole");
        String userId = "123" + total;
        if (user.getId() != null && user.getPassword() != null && role != null) {
            userService.saveUser(new User(user.getId(), userId,
                    user.getPassword(), role));
            return "redirect:/users";
        }
        return "addNewUser";
    }

    @RequestMapping("/user/edit/{id}")
    public String editUser(@PathVariable String id, HttpServletRequest request, Model model) {
         User user1 = (User) request.getSession().getAttribute("user");
         if (user1 == null || !user1.getRole().equals("admin"))
             return "redirect:/";
        try {
            User user = userService.findById(id);
            model.addAttribute("user", user);//user
            model.addAttribute("admin", "admin");//user
            model.addAttribute("student", "student");//user
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "updateUser";
    }

    @RequestMapping("/user/update/{id1}")
    public String updateUser(@PathVariable String id1, @ModelAttribute("user") User user, HttpServletRequest request) {
        User updateUser = userService.findById(id1);
        String role = request.getParameter("userRole");

        if (user.getId() != null && user.getPassword() != null && role != null) {
            try {
                updateUser.setId(user.getId());
                updateUser.setPassword(user.getPassword());
                updateUser.setRole(role);
                userService.updateUser(updateUser);
                return "redirect:/users";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return "updateUser";
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        System.out.println(id);
        try {
            User user = userService.findById(id);
            userService.deleteById(user.getId());
        } catch (Exception e) {
            System.out.println("Error for this: " + e.getMessage());
        }
        return "redirect:/users";
    }

    @RequestMapping("/exams")
    public String exam(Model model, HttpServletRequest request) {
       //  User user = (User) request.getSession().getAttribute("user");
        // if (user == null || !user.getRole().equals("admin"))
         //  return "redirect:/";

        List<Exam> exams = examService.findAll();
        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        model.addAttribute("exams", exams);
        return "adminExam";
    }

    @RequestMapping("/exam/add")
    public String addNewExam(Model model, HttpServletRequest request) {
        //  User user = (User) request.getSession().getAttribute("user");
        //if (user == null || !user.getRole().equals("admin"))
        //  return "redirect:/";
        String term = request.getParameter("term");
        String examDuration = request.getParameter("examDuration");
        String subjectId = request.getParameter("subject");
        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        int total = examService.findAll().size();
        String examId = "123" + total;

        System.out.println(subjectId);
        String examDate = request.getParameter("examDate");
        Subject subject = null;
        if (subjectId != null)
            subject = subjectService.findById(subjectId);
        LocalDateTime localDateTime = null;
        if (examDate != null)
            localDateTime = LocalDateTime.parse(examDate);


        if (term != null && examDuration != null && subject != null && localDateTime != null && examId != null) {
            examService.saveExam(new Exam(examId, localDateTime, term, Integer.valueOf(examDuration), subject));
            return "redirect:/exams";
        }
        return "addExam";
    }
    @RequestMapping("/exam/delete/{id}")
    public String deleteExam(@PathVariable String id) {
        try {
            examService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/exams";
    }


    @RequestMapping("/exam/question/{id}")
    public String question(@PathVariable String id, Model model) {
        try {
            List<Question> questions = questionService.findAll();
            List<Answer> answers = answerService.findAll();
            model.addAttribute("questions", questions);
            model.addAttribute("answers", answers);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "panelQuestion";
    }
    @RequestMapping("/question/add/{id}")
    public String addNewQuestion(@PathVariable String id, Model model, HttpServletRequest request) {
     //   User user = (User) request.getSession().getAttribute("user");
      //  if (user == null || !user.getRole().toLowerCase().equals("admin"))
        //    return "redirect:/";
        if (id != null) {
            Subject subject = subjectService.findById(id);
            String term = request.getParameter("term");

            int que=questionService.findAll().size();
            String questionsId= String.valueOf(++que);
            Exam examId=null;

            model.addAttribute("subject", subject);
            String question1 = request.getParameter("question");
            String answer1 = request.getParameter("answer1");
            String answer2 = request.getParameter("answer2");
            String answer3 = request.getParameter("answer3");
            String answer4 = request.getParameter("answer4");
            List<Exam> exams = examService.findAll();
            for(Exam exam: exams){
                if(exam.getSubjectId().getId().equalsIgnoreCase(id))
                    examId=exam;
            }

            long questionId = questionService.findAll().size();
            long answerId = answerService.findAll().size();
            if (questionsId!=null && question1 != null && answer1 != null && answer2 != null && answer3 != null && answer4 != null && term != null) {
                // add question table
                Question question = new Question(questionsId,question1,subject,examId,term);
                questionService.saveQuestion(question);

                // first answer
                // add answer to answer table
                Answer answer = new Answer();
                answer.setId(String.valueOf(++answerId));
                answer.setAnswer(answer1);
                answer.setStatus("false");
                answer.setQuestionId(question);
                answerService.saveAnswer(answer);

                // second answer false answer
                answer.setId(String.valueOf(++answerId));
                answer.setAnswer(answer2);
                answer.setStatus("false");
                answer.setQuestionId(question);
                answerService.saveAnswer(answer);

                // third answer  false answer
                answer.setId(String.valueOf(++answerId));
                answer.setAnswer(answer3);
                answer.setStatus("false");
                answer.setQuestionId(question);
                answerService.saveAnswer(answer);

                // fourth answer true answer
                answer.setId(String.valueOf(++answerId));
                answer.setAnswer(answer4);
                answer.setStatus("true");
                answer.setQuestionId(question);
                answerService.saveAnswer(answer);
                return "redirect:/exam/question/" + id;
            }
        }
        return "addNewQuestion";
    }

    @RequestMapping("/score")
    public String score(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getRole().equals("admin"))
            return "redirect:/";
        return "score";
    }

    @RequestMapping("/student/add")
    public String addNewStudent(@ModelAttribute("student") Student student, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getRole().equals("admin"))
            return "redirect:/";
        int total = studentService.findAll().size();
        String studentId = "123" + total;
        if (student.getName() != null && student.getSurname() != null && student.getEmail() != null) {
            studentService.saveStudent(new Student(studentId, student.getName(),
                    student.getSurname(), student.getEmail()));
            return "redirect:/students";
        }
        return "addNewStudent";
    }

    @RequestMapping("/student/edit/{id}")
    public String editStudent(@PathVariable String id, HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getRole().equals("admin"))
            return "redirect:/";
        try {
            Student student = studentService.findById(id);
            model.addAttribute("student", student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "updateStudent";
    }

    @RequestMapping("/student/update/{id}")
    public String updateStudent(@PathVariable String id, @ModelAttribute("student") Student student, HttpServletRequest request) {
        Student updateStudent = studentService.findById(id);
        if (student.getName() != null && student.getSurname() != null && student.getEmail() != null) {
            updateStudent.setName(student.getName());
            updateStudent.setSurname(student.getSurname());
            updateStudent.setEmail(student.getEmail());
            studentService.updateStudent(updateStudent);
            return "redirect:/students";
        }
        return "updateStudent";
    }

    @RequestMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        try {
            studentService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/students";
    }

   /* @RequestMapping("/user/add")
    public String addNewUser(){
        return null;
    } */
  /*  @RequestMapping("/exam/add")
    public String addNewExam(){
        return null;
    }
    */
   /*
    @RequestMapping("/subject/add")
    public String addNewSubject(){
        return null;
    }
*/


    @RequestMapping("/user/edit")
    public String editUser() {

        return null;
    }

    @RequestMapping("/user/update")
    public String updateUser() {

        return null;
    }

}

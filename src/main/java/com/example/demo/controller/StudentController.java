package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    private ExamService examService;
    private SubjectService subjectService;
    private QuestionService questionService;
    private AnswerService answerService;
    private StudentService studentService;
    private AnswerSheetService answerSheetService;

    public StudentController(ExamService examService, SubjectService subjectService, QuestionService questionService, AnswerService answerService, StudentService studentService, AnswerSheetService answerSheetService) {
        this.examService = examService;
        this.subjectService = subjectService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.studentService = studentService;
        this.answerSheetService = answerSheetService;
    }

    @RequestMapping("/student")
    public String studentPanel(HttpServletRequest request) {
        // User user = (User) request.getSession().getAttribute("user");
        //  if (user!=null && user.getRole().equals("student"))
        return "student";
        //  return "redirect:/";
    }

    @RequestMapping("/student/exams")
    public String examPanel(Model model, HttpServletRequest request) {
        //    User user = (User) request.getSession().getAttribute("user");
        //  if (user == null || !user.getRole().equalsIgnoreCase("student"))
        //    return "redirect:/";

        List<Subject> subjects = subjectService.findAll();
        String examButton = "disabled";
        String color = "none";
        String buttonVa = "Waiting";
        List<Exam> exams = examService.findAll();
        HashMap<String, String> examButtons = new HashMap<>();
        HashMap<String, String> buttonValue = new HashMap<>();
        HashMap<String, String> buttonColor = new HashMap<>();

        for (Exam exam : exams) {
            if (exam.getExamDate().isAfter(LocalDateTime.now())) {
                LocalDateTime examDateTime = LocalDateTime.ofInstant(exam.getExamDate().toInstant(ZoneOffset.UTC), ZoneOffset.UTC);
                Duration duration = Duration.between(LocalDateTime.now(), examDateTime);
                long days = (duration.getSeconds() / (60 * 60 * 24));
                long hours = (duration.getSeconds() % (60 * 60 * 24) / (3600));
                long minute = (duration.getSeconds() % (60 * 60 * 24) % 3600) / (60);
                System.out.println("days " + days);
                System.out.println("hours " + hours);
                System.out.println("minutes " + minute);
                if (days == 0 && hours == 0 && minute <= 0 && minute >= -exam.getDuration()) {
                    examButton = "enabled";
                    color = "green";
                    buttonVa = "Start";
                } else if (days >= 0 && hours >= 0 && minute >= 0) {
                    examButton = "disabled";
                    color = "none";
                    buttonVa = "Waiting";
                } else {
                    examButton = "disabled";
                    color = "red";
                    buttonVa = "Finished";

                }
                System.out.println("After ");

            } else {
                examButton = "disabled";
                buttonVa = "Finished";
                color = "red";
                System.out.println("before");
            }
            examButtons.put(exam.getSubjectId().getId(), examButton);
            buttonValue.put(exam.getSubjectId().getId(), buttonVa);
            buttonColor.put(exam.getSubjectId().getId(), color);
        }
        model.addAttribute("subjects", subjects);
        model.addAttribute("exams", exams);
        model.addAttribute("examButtons", examButtons);
        model.addAttribute("buttonColor", buttonColor);
        model.addAttribute("buttonValue", buttonValue);
        return "examPanel";
    }

    @RequestMapping("/exam/{id}")
    public String exam(@PathVariable String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        //    User user = (User) request.getSession().getAttribute("user");
        //  if (user == null || !user.getRole().equalsIgnoreCase("student"))
        //    return "redirect:/";
        List<Question> questions = questionService.findAll();
        List<String> answersKey = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        for (Question question : questions)
            if (cookies != null)
                for (Cookie cookie : cookies)
                    if (cookie.getName().equals(question.getId())) {
                        cookie.setPath("/exam");
                        answersKey.add(cookie.getValue());
                    }
        List<Answer> answerList = answerService.findAll();
        for(Answer answer:answerList){
            System.out.println(answer.getAnswer());
        }
        model.addAttribute("questions", questions);
        model.addAttribute("answers", answerList);
        model.addAttribute("midterm", "Midterm");
        model.addAttribute("id", id);
        model.addAttribute("answerKeys", answersKey);
        return "exam";
    }
    @RequestMapping("/answer/submit/{id}")
    public String answerSubmit(@PathVariable String id,  HttpServletRequest request, HttpServletResponse response) {
        List<Question> questions = questionService.findAllQuestionBySubjectID(id);
        Cookie[] cookies = request.getCookies();
        int total= answerSheetService.findAll().size();
        String answerSheetId= String.valueOf(++total);
        AnswerSheet answerSheet = null;
        for (Question question : questions) {
            Answer answerId = answerService.findAnswerById(request.getParameter(question.getId()));
                AnswerSheet newAnswerSheet = new AnswerSheet(answerSheetId,question,answerId);
                answerSheetService.saveAnswerSheet(newAnswerSheet);
                if (question != null) {
                    if (cookies != null)
                        for (Cookie cookie : cookies)
                            if (!cookie.getName().equals(question.getId())) {
                                Cookie newCookie = new Cookie(question.getId(), answerId.getId());
                                newCookie.setPath("/exam");
                                newCookie.setMaxAge(60 * 50);
                                response.addCookie(newCookie);
                            }
                }
                AnswerSheet updateAnswerSheet = answerSheet;
                updateAnswerSheet.setId(answerSheetId);
                answerSheetService.updateAnswerSheet(updateAnswerSheet);
        }
        return "redirect:/student/exams";
    }

}

package org.example.exercice5doglist.controller;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.exercice5doglist.model.Dog;
import org.example.exercice5doglist.service.DogService;

@WebServlet(name = "dogServlet", value = "/dog/*")
public class DogServlet extends HttpServlet {

    private DogService dogService;

    @Override
    public void init() throws ServletException {
            dogService = new DogService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getPathInfo();
        switch (path) {
            case "/list-dog":
                listDog(request, response);
                break;
            case "/add-dog":
                addDog(request, response);
                break;
            case "/details-dog":
                detailsDog(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));

        Dog dog = new Dog(name, breed, dateOfBirth);

        dogService.create(dog);

        req.setAttribute("dogList", dogService.findAll());

        req.getRequestDispatcher("/WEB-INF/list-dog.jsp").forward(req, resp);
    }

    private void listDog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dogList", dogService.findAll());
        request.getRequestDispatcher("/WEB-INF/list-dog.jsp").forward(request, response);
    }

    private void addDog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/add-dog.jsp").forward(request, response);
    }

    private void detailsDog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dog> dogList = dogService.findAll();
        request.setAttribute("dogList", dogList);
        String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "" ;
        int dogId = 0;
        if (pathInfo != null && !pathInfo.isEmpty()){
           dogId = dogList.get(Integer.parseInt(pathInfo.substring(1))).getId();
        }
        request.setAttribute("dogId", dogId);
        request.getRequestDispatcher("/WEB-INF/details-dog.jsp").forward(request, response);

    }

}
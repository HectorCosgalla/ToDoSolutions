package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todoapp.models.Task;

@WebServlet("/task")
public class TaskController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            Connection connection = DatabaseConnection.initializeConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tasks (?, ?)");
            Task task = new Task(request.getParameter("title"));
            statement.setString(1, task.getTitle());
            statement.setBoolean(2, task.getItsDone());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
}

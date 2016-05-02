package com.fujitsu.fs.javalab.poll.webapp.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.fujitsu.fs.javalab.poll.webapp.db.PollDaoHsqldb;
import com.fujitsu.fs.javalab.poll.webapp.entity.Poll;

@WebServlet(name = "PollsController", urlPatterns = "/polls")
public class PollsController extends HttpServlet {

    private PollDaoHsqldb pollDaoHsqldb;

    @Override
    public void init() throws ServletException {
        pollDaoHsqldb = new PollDaoHsqldb();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Poll> polls = pollDaoHsqldb.selectPolls();

        req.setAttribute("polls", polls);
        req.getRequestDispatcher("/WEB-INF/jsp/polls.jsp").forward(req, resp);
    }
}

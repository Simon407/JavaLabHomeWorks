package com.fujitsu.fs.javalab.poll.webapp.controllers;

import com.fujitsu.fs.javalab.poll.webapp.db.PollDaoHsqldb;
import com.fujitsu.fs.javalab.poll.webapp.entity.Poll;
import com.fujitsu.fs.javalab.poll.webapp.entity.PollChoice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PollController", urlPatterns = "/poll")
public class PollController extends HttpServlet {

    private PollDaoHsqldb pollDaoHsqldb;

    @Override
    public void init() throws ServletException {
        pollDaoHsqldb = new PollDaoHsqldb();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Poll poll = pollDaoHsqldb.selectByIdFromPoll(id);
        req.setAttribute("poll", poll);
        req.getRequestDispatcher("/WEB-INF/jsp/poll.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(req.getParameter("id"));
        String result = req.getParameter("result");

        int rowsAffected = pollDaoHsqldb.insertIntoPollChoice(new PollChoice(id, result, 0L));
        if (rowsAffected == 1) {
            Map<String, Integer> polls = getCountPeople(pollDaoHsqldb.selectFromPollChoice(id));
            if (polls != null) {
                req.setAttribute("pollsKey", polls.keySet());
                req.setAttribute("polls", polls);
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(req, resp);
    }

    private Map<String, Integer> getCountPeople(List<PollChoice> polls) {
        Map<String, Integer> map = new LinkedHashMap();
        for (PollChoice poll1 : polls) {
            if (!map.containsKey(poll1.getChoiceText())) {
                map.put(poll1.getChoiceText(), 0);
            }
        }
        for (String choiceText : map.keySet()) {
            for (PollChoice poll2 : polls) {
                if (choiceText.equals(poll2.getChoiceText())) {
                    map.put(choiceText, new Integer(map.get(choiceText) + 1));
                }
            }
        }

        return map;
    }
}

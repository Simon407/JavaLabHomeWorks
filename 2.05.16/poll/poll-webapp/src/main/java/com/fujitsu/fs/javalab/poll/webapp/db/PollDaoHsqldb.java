package com.fujitsu.fs.javalab.poll.webapp.db;

import com.fujitsu.fs.javalab.poll.webapp.entity.Poll;
import com.fujitsu.fs.javalab.poll.webapp.entity.PollChoice;
import org.hsqldb.jdbc.JDBCDriver;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PollDaoHsqldb {

    private static final String SELECT_BY_ID = "SELECT ID, TITLE from POLL WHERE ID = ?";
    private static final String INSERT = "INSERT INTO POLL_CHOICE (CHOICE_TEXT ,VOTES,POLL_ID) VALUES (?,?,?)";
    private static final String SELECT_BY_POLL_ID = "SELECT ID,CHOICE_TEXT ,VOTES,POLL_ID from POLL_CHOICE WHERE POLL_ID = ?";
    private static final String SELECT_POLLS = "SELECT ID, TITLE from POLL ORDER BY TITLE";
    private static final String SELECT_BY_POLL_ID_AND_TEXT = "SELECT ID,CHOICE_TEXT ,VOTES,POLL_ID from POLL_CHOICE WHERE POLL_ID = ? AND CHOICE_TEXT = ?";

    public Poll selectByIdFromPoll(Long id) throws ServletException {
        Poll poll;
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            poll = new Poll(rs.getLong("ID"), rs.getString("TITLE"));
        } catch (SQLException e) {
            throw new ServletException("Close another connection! or it smt else SQLException in selectByIdFromPoll", e);
        }
        return poll;
    }

    public int insertIntoPollChoice(PollChoice poll) throws ServletException {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(INSERT)) {
            statement.setString(1, poll.getChoiceText());
            statement.setLong(2, poll.getVotes());
            statement.setLong(3, poll.getPollId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("Close another connection! or it smt else SQLException in insertIntoPollChoice", e);
        }
    }

    public List<PollChoice> selectFromPollChoice(Long id) throws ServletException {
        List<PollChoice> polls = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_BY_POLL_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                polls.add(new PollChoice(rs.getLong("ID"), rs.getLong("VOTES"), rs.getString("CHOICE_TEXT"), rs.getLong("POLL_ID")));
            }
        } catch (SQLException e) {
            throw new ServletException("Close another connection! or it smt else SQLException in selectFromPollChoice", e);
        }
        return polls;
    }

    public List<Poll> selectPolls() throws ServletException {
        List<Poll> polls = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_POLLS);
            while (rs.next()) {
                polls.add(new Poll(rs.getLong("ID"), rs.getString("TITLE")));
            }
        } catch (SQLException e) {
            throw new ServletException("Close another connection! or it smt else SQLException in selectPolls", e);
        }
        return polls;
    }

    public PollDaoHsqldb() throws ServletException {
        try {
            Class.forName(JDBCDriver.class.getName());
        } catch (ClassNotFoundException e) {
            throw new ServletException("HSQLD driver was not found", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:c://tm//db//poll", "sa", "");
    }
}

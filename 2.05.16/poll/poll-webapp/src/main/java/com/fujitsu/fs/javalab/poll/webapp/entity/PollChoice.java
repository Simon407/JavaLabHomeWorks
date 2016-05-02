package com.fujitsu.fs.javalab.poll.webapp.entity;


public class PollChoice {
    private Long id;
    private Long pollId;
    private String choiceText;
    private Long votes;

    public PollChoice(Long id, Long pollId, String choiceText, Long votes) {
        this.id = id;
        this.pollId = pollId;
        this.choiceText = choiceText;
        this.votes = votes;
    }

    public PollChoice(Long pollId, String choiceText, Long votes) {
        this.pollId = pollId;
        this.choiceText = choiceText;
        this.votes = votes;
    }

    public PollChoice() {
    }

    @Override
    public String toString() {
        return "PollChoice{" +
                "id=" + id +
                ", pollId=" + pollId +
                ", choiceText='" + choiceText + '\'' +
                ", votes=" + votes +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }
}

package com.oyy.pojo;

public class Role
{
    private String username;
    private Integer score;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    public String toString()
    {
        return "Role{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}

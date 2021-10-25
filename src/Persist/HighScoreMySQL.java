package Persist;

import Core.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HighScoreMySQL implements HighScore {
    private String driver ="com.mysql.jdbc.Driver";
    private String url;
    private String username;
    private String pwd;

    private List<Entry> highscores;
    private List<Entry> bdhighscores;

    public HighScoreMySQL(String url, String username, String pwd) {
        this.url = url;
        this.username = username;
        this.pwd = pwd;
        this.highscores = new ArrayList<>();
        this.bdhighscores = new ArrayList<>();
    }

    @Override
    public void save(Entry score) {
        Statement stmt = this.getStatement();
        try {
            System.out.println("INSERT INTO highscore(name,score,gameDate) values('"+score.getPlayer().getName()+"',"
                    +score.getScore()+",'"+score.getGameDate().toString()+"') ");
            stmt.executeUpdate("INSERT INTO highscore(name,score,gameDate) values('"+score.getPlayer().getName()+"',"
                                    +score.getScore()+",'"+score.getGameDate().toString()+"') ");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void load() {
        Statement stmt = this.getStatement();

        try {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM highscore");
            while (resultSet.next()){
                this.bdhighscores.add(new Entry(resultSet.getInt(2),null,new Player(resultSet.getString(1))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void add(Entry bestScore) {
        this.highscores.add(bestScore);
    }

    private Statement getStatement(){
        Statement stmt=null;
        try {
            Class.forName(this.driver);
            Connection con= DriverManager.getConnection(this.url,this.username,this.pwd);
            stmt = con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return stmt;
    }


}
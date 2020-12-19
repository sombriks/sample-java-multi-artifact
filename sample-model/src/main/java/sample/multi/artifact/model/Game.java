package sample.multi.artifact.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Game {
  private Long id;
  private Date createdAt;
  private Map<String, ScoreBoard> boards = new HashMap<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Map<String, ScoreBoard> getBoards() {
    return boards;
  }

  public void setBoards(Map<String, ScoreBoard> boards) {
    this.boards = boards;
  }
}

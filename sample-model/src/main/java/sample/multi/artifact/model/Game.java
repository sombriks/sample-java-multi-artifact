package sample.multi.artifact.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date createdAt;

  @JoinColumn(name = "gameId", nullable = false)
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Line> lines = new ArrayList<>();

  @Transient
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

  public List<Line> getLines() {
    return lines;
  }

  public void setLines(List<Line> lines) {
    this.lines = lines;
  }

  public Map<String, ScoreBoard> getBoards() {
    return boards;
  }

  public void setBoards(Map<String, ScoreBoard> boards) {
    this.boards = boards;
  }
}

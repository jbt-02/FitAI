package com.fitai.fitai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "program")
public class Program {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long programId;

  private String name;
  private String programMetadata;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;

  @OneToMany(mappedBy = "program")
  private List<WeekWorkout> weekWorkoutList = new ArrayList<>();

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public long getprogramId() {
    return programId;
  }

  public void setprogramId(long programId) {
    this.programId = programId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProgramMetaData getProgram_metadata() {
    return this.programMetadata;
  }

  public void setProgram_metadata(ProgramMetaData program_metadata) {
    this.programMetadata = program_metadata;
  }

  public List<WeekWorkout> getWeekWorkouts() {
    return this.weekWorkoutList;
  }

  public void setWeekWorkouts(List<WeekWorkout> weekWorkoutList) {
    this.weekWorkoutList = weekWorkoutList;
  }

  public void addWeekWorkout(WeekWorkout weekWorkout) {
    this.weekWorkoutList.add(weekWorkout);
  }
}

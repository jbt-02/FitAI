package com.fitai.fitai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "weekWorkout")
public class WeekWorkout {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long weekWorkoutId;

  @CreationTimestamp
  private LocalDateTime createdAt;

  private String description;

  @OneToMany(mappedBy = "weekWorkout", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Workout> workoutList = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "programId")
  private Program program;

  public long getId() {
    return weekWorkoutId;
  }

  public void setId(long id) {
    this.weekWorkoutId = id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Program getProgram() {
    return this.program;
  }

  public void setProgram(Program program) {
    this.program = program;
  }

  public List<Workout> getWorkoutList() {
    return this.workoutList;
  }

  public void setWorkoutList(List<Workout> workoutList) {
    this.workoutList = workoutList;
  }

  public void addWorkoutList(Workout workout) {
    this.workoutList.add(workout);
  }
}

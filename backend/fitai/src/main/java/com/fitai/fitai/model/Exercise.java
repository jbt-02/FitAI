package com.fitai.fitai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercises")
public class Exercise {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long exerciseId;

  private String name;

  @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<WorkoutExercise> workoutExercises = new ArrayList<>();

  public long getId() {
    return exerciseId;
  }

  public void setId(long id) {
    this.exerciseId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<WorkoutExercise> getWorkoutExercises() {
    return this.workoutExercises;
  }

  public void setWorkoutExercise(List<WorkoutExercise> workoutExercises) {
    this.workoutExercises = workoutExercises;
  }
}

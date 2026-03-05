package com.fitai.fitai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exerciseSet")
public class ExerciseSet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long exerciseSetId;

  private int setNumber;
  private String reps;
  private String weight;
  private boolean isComplete;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workoutExerciseId", nullable = false)
  private WorkoutExercise workoutExercise;

  public WorkoutExercise getWorkoutExercise() {
    return this.workoutExercise;
  }

  public void setWorkoutExercise(WorkoutExercise workoutExercise) {
    this.workoutExercise = workoutExercise;
  }

  public int getSetNumber() {
    return this.setNumber;
  }

  public void setSetNumber(int setNumber) {
    this.setNumber = setNumber;
  }

  public boolean getIsComplete() {
    return this.isComplete;
  }

  public long getExerciseSetId() {
    return this.exerciseSetId;
  }

  public String getReps() {
    return this.reps;
  }

  public String getWeight() {
    return this.weight;
  }

  public void setIsComplete(boolean isComplete) {
    this.isComplete = isComplete;
  }

  public void setExerciseSetId(long exerciseSetId) {
    this.exerciseSetId = exerciseSetId;
  }

  public void setReps(String reps) {
    this.reps = reps;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }
}

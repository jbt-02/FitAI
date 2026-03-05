package com.fitai.fitai.model.trackedmodels;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "trackedExerciseSet")
public class TrackedExerciseSet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long trackedExerciseSetId;

  private String reps;
  private String weight;
  private boolean isComplete;

  @ManyToOne
  @JoinColumn(name = "trackedWorkoutId")
  private TrackedWorkout trackedWorkout;

  @ManyToOne
  @JoinColumn(name = "trackedExerciseId")
  private TrackedExercise trackedExercise;

  public TrackedWorkout getTrackedWorkout() {
    return this.trackedWorkout;
  }

  public void setTrackedWorkout(TrackedWorkout workout) {
    this.trackedWorkout = workout;
  }

  public boolean getIsComplete() {
    return this.isComplete;
  }

  public long getExerciseSetId() {
    return this.trackedExerciseSetId;
  }

  public String getReps() {
    return this.reps;
  }

  public String getWeight() {
    return this.weight;
  }

  public TrackedExercise getExercise() {
    return this.trackedExercise;
  }

  public void setIsComplete(boolean isComplete) {
    this.isComplete = isComplete;
  }

  public void setTrackedExerciseSetId(long trackedExerciseSetId) {
    this.trackedExerciseSetId = trackedExerciseSetId;
  }

  public void setReps(String reps) {
    this.reps = reps;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public void setExercise(TrackedExercise exercise) {
    this.trackedExercise = exercise;
  }

}

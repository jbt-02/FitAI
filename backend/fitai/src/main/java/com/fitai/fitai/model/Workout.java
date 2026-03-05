package com.fitai.fitai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;

import com.fitai.fitai.model.TrackedModels.TrackedWorkout;
import com.fitai.fitai.enums.WorkoutProgress;

import jakarta.persistence.Column;

@Entity
@Table(name = "workouts")
public class Workout {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long workoutId;

  private String name;
  private String description;

  // Day can be from (0 = Monday) to (6 = Sunday)
  private String day;

  @Enumerated(EnumType.STRING)
  private WorkoutProgress progress;
  private String feedback;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "completedAt")
  private LocalDateTime completedAt;

  @ManyToOne
  @JoinColumn(name = "weekWorkoutId")
  private WeekWorkout weekWorkout;

  @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @OrderBy("orderIndex ASC")
  private List<WorkoutExercise> workoutExercises = new ArrayList<>();

  public long getId() {
    return workoutId;
  }

  public void setId(long id) {
    this.workoutId = id;
  }

  public LocalDateTime getCompletedTime() {
    return this.completedAt;
  }

  public void setCompletedTime(LocalDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public void createWorkout() {
    this.progress = WorkoutProgress.DRAFT;
  }

  public void saveWorkout() {
    this.progress = WorkoutProgress.IN_PROGRESS;
  }

  public void completeWorkout() {
    this.progress = WorkoutProgress.COMPLETE;
    this.completedAt = LocalDateTime.now();
  }

  public String getFeedback() {
    return this.feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDay() {
    return this.day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public WeekWorkout getWeekWorkout() {
    return weekWorkout;
  }

  public void setWeekWorkout(WeekWorkout weekWorkout) {
    this.weekWorkout = weekWorkout;
  }

  public List<WorkoutExercise> getWorkoutExercises() {
    return this.workoutExercises;
  }

  public void setExercises(List<WorkoutExercise> workoutExercises) {
    this.workoutExercises = workoutExercises;
  }

  public WorkoutProgress getProgress() {
    return this.progress;
  }

  public void setProgress(WorkoutProgress progress) {
    this.progress = progress;
  }
}

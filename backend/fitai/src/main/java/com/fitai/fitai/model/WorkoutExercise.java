package com.fitai.fitai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fitai.fitai.enums.ExerciseProgress;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "workoutExercises")
public class WorkoutExercise {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workoutId", nullable = false)
  private Workout workout;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "exerciseId", nullable = false)
  private Exercise exercise;

  @Column(name = "orderIndex", nullable = false)
  private int orderIndex;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @OrderBy("setNumber ASC")
  private List<ExerciseSet> exerciseSets = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ExerciseProgress progress = ExerciseProgress.DRAFT;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Workout getWorkout() {
    return this.workout;
  }

  public void setWorkout(Workout workout) {
    this.workout = workout;
  }

  public Exercise getExercise() {
    return this.exercise;
  }

  public void setExercise(Exercise exercise) {
    this.exercise = exercise;
  }

  public List<ExerciseSet> getExerciseSets() {
    return this.exerciseSets;
  }

  public void setExerciseSets(List<ExerciseSet> exerciseSets) {
    this.exerciseSets = exerciseSets;
  }

  public int getOrderIndex() {
    return this.orderIndex;
  }

  public void setOrderIndex(int orderIndex) {
    this.orderIndex = orderIndex;
  }

  public ExerciseProgress getProgress() {
    return this.progress;
  }

  public void createExercise() {
    this.progress = ExerciseProgress.DRAFT;
  }

  public void saveExercise() {
    this.progress = ExerciseProgress.IN_PROGRESS;
  }

  public void completeExercise() {
    this.progress = ExerciseProgress.COMPLETE;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }
}

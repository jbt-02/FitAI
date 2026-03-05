package com.fitai.fitai.model.trackedmodels;

import com.fitai.fitai.model.WeekWorkout;
import com.fitai.fitai.model.Workout;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fitai.fitai.model.User;

@Entity
@Table(name = "trackedWorkouts")
public class TrackedWorkout {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long trackedWorkoutId;

  private String name;
  private String description;

  // Day can be from (0 = Monday) to (6 = Sunday)
  private String day;

  private String progress;
  private String feedback;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;

  @Column(name = "completedAt")
  private LocalDateTime completedAt;

  @ManyToOne
  @JoinColumn(name = "weekWorkoutId")
  private WeekWorkout weekWorkout;

  @OneToMany(mappedBy = "trackedWorkout", cascade = CascadeType.ALL)
  private List<TrackedExercise> trackedExercises = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "workoutId", referencedColumnName = "workoutId")
  private Workout workoutTemplate;

  public long getId() {
    return trackedWorkoutId;
  }

  public void setId(long id) {
    this.trackedWorkoutId = id;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LocalDateTime getCompletedTime() {
    return this.completedAt;
  }

  public void setCompletedTime(LocalDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public String getProgress() {
    return this.progress;
  }

  public void setProgress(String progress) {
    this.progress = progress;
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

  public WeekWorkout getWeekWorkout() {
    return weekWorkout;
  }

  public void setWeekWorkout(WeekWorkout weekWorkout) {
    this.weekWorkout = weekWorkout;
  }

  public List<TrackedExercise> getTrackedExercises() {
    return trackedExercises;
  }

  public void setTrackedExercises(List<TrackedExercise> exercises) {
    this.trackedExercises = exercises;
  }

  public void addExercise(TrackedExercise exercise) {
    this.trackedExercises.add(exercise);
  }

  public Workout getWorkout() {
    return this.workoutTemplate;
  }

  public void setWorkout(Workout workout) {
    this.workoutTemplate = workout;
  }
}

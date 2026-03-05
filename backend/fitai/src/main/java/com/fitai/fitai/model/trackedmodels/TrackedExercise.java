package com.fitai.fitai.model.trackedmodels;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import com.fitai.fitai.model.Exercise;

import jakarta.persistence.CascadeType;

@Entity
@Table(name = "trackedExercise")
public class TrackedExercise {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long trackedExerciseId;

  @ManyToOne
  Exercise templateExercise;

  private String name;

  @ManyToOne
  private TrackedWorkout trackedWorkout;

  @OneToMany(mappedBy = "trackedExercise", cascade = CascadeType.ALL)
  private List<TrackedExerciseSet> trackedSets = new ArrayList<>();

  public long getId() {
    return trackedExerciseId;
  }

  public void setId(long id) {
    this.trackedExerciseId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTrackedWorkout(TrackedWorkout trackedWorkout) {
    this.trackedWorkout = trackedWorkout;
  }

  public TrackedWorkout getTrackedWorkout() {
    return this.trackedWorkout;
  }

  public List<TrackedExerciseSet> getSets() {
    return trackedSets;
  }

  public void setSets(List<TrackedExerciseSet> sets) {
    this.trackedSets = sets;
  }

  public void addSet(TrackedExerciseSet set) {
    this.trackedSets.add(set);
  }
}

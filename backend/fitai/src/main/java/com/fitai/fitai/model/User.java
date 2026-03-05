package com.fitai.fitai.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uid;

  private String fname;
  private String lname;
  private int age;
  private char sex;

  @Column(nullable = false, unique = true)
  private String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(nullable = false)
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "user")
  private List<Program> programs = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TrackedWorkout> trackedWorkouts = new ArrayList<>();

  public UUID getID() {
    return this.uid;
  }

  public String getFname() {
    return this.fname;
  }

  public String getLname() {
    return this.lname;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public List<Program> getPrograms() {
    return this.programs;
  }

  public int getAge() {
    return this.age;
  }

  public char getSex() {
    return this.sex;
  }

  public void setID(UUID id) {
    this.uid = id;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setPrograms(List<Program> programs) {
    this.programs = programs;
  }

  public void addProgram(Program program) {
    this.programs.add(program);
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public List<TrackedWorkout> getTrackedWorkouts() {
    return this.trackedWorkouts;
  }

  public void setTrackedWorkouts(List<TrackedWorkout> trackedWorkouts) {
    this.trackedWorkouts = trackedWorkouts;
  }
}

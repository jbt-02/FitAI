package com.fitai.fitai.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*  String mainFitnessGoal, String fitnessExperience, String daysPerWeek,
    String mainLocationToWorkout,
    String currentBodyweight, String pastInjuries, String userEmail*/

@Entity
@Table(name = "programmetadata")
public class ProgramMetaData {

  @Id
  @GeneratedValue
  private UUID ProgramMetaData;

  private String mainFitnessGoal;
  private String fitnessExperience;
  private String daysPerWeek;
  private String mainLocationToWorkout;
  private String currentBodyweight;
  private String pastInjuries;

  @OneToOne
  @JoinColumn(name = "programId", referencedColumnName = "programId")
  private Program program;

  public UUID getProgramMetaData() {
    return ProgramMetaData;
  }

  public void setProgramMetaData(UUID programMetaData) {
    this.ProgramMetaData = programMetaData;
  }

  public String getMainFitnessGoal() {
    return mainFitnessGoal;
  }

  public void setMainFitnessGoal(String mainFitnessGoal) {
    this.mainFitnessGoal = mainFitnessGoal;
  }

  public String getFitnessExperience() {
    return fitnessExperience;
  }

  public void setFitnessExperience(String fitnessExperience) {
    this.fitnessExperience = fitnessExperience;
  }

  public String getDaysPerWeek() {
    return daysPerWeek;
  }

  public void setDaysPerWeek(String daysPerWeek) {
    this.daysPerWeek = daysPerWeek;
  }

  public String getMainLocationToWorkout() {
    return mainLocationToWorkout;
  }

  public void setMainLocationToWorkout(String mainLocationToWorkout) {
    this.mainLocationToWorkout = mainLocationToWorkout;
  }

  public String getCurrentBodyweight() {
    return currentBodyweight;
  }

  public void setCurrentBodyweight(String currentBodyweight) {
    this.currentBodyweight = currentBodyweight;
  }

  public String getPastInjuries() {
    return pastInjuries;
  }

  public void setPastInjuries(String pastInjuries) {
    this.pastInjuries = pastInjuries;
  }

  public Program getProgram() {
    return program;
  }

  public void setProgram(Program program) {
    this.program = program;
  }
}

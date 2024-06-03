package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, unique = true)
	private Long id;

	@Column
	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			fetch = FetchType.LAZY,
			orphanRemoval = true
	)
	@JoinColumn(name = "VISIT_ID")
	private Collection<MedicalTreatmentEntity> medicalTreatments;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private DoctorEntity doctor;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private PatientEntity patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Collection<MedicalTreatmentEntity> getMedicalTreatments() {
		return medicalTreatments;
	}

	public void setMedicalTreatments(Collection<MedicalTreatmentEntity> medicalTreatments) {
		this.medicalTreatments = medicalTreatments;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
}

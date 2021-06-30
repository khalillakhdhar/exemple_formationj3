package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "formations")
public class Formation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@NotBlank
@Column(nullable= false)
private String titre;
@Size(max = 100)
@Null
private String description;
@Column(unique = true,length = 30)
private String formateur;
@NotNull
private int duree;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getFormateur() {
	return formateur;
}
public void setFormateur(String formateur) {
	this.formateur = formateur;
}
public int getDuree() {
	return duree;
}
public void setDuree(int duree) {
	this.duree = duree;
}


}

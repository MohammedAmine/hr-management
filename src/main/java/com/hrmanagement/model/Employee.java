package com.hrmanagement.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	@NotNull(message = "An employee's first name cannot be empty")
	@Size(min = 5, max = 20, message = "An employee's first name must contain between 5 and 20 characters")
	private String firstName;

	@Column
	@NotNull(message = "An employee's last name cannot be empty")
	@Size(min = 5, max = 20, message = "An employee's last name must contain between 5 and 20 characters")
	private String lastName;

	@Column
	@NotNull(message = "An employee's job function cannot be empty")
	@Size(min = 3, max = 20, message = "An employee's job function must contain between 3 and 20 characters")
	private String jobFunction;

	@Column
	@NotNull(message = "An employee's salary cannot be empty")
	@Min(value = 0, message = "An employee's salary cannot be negative")
	private int salary;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYER_ID")
	private Company employer;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Company getEmployer() {
		return employer;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (firstName != null && !firstName.trim().isEmpty())
			result += "firstName: " + firstName;
		if (lastName != null && !lastName.trim().isEmpty())
			result += ", lastName: " + lastName;
		if (jobFunction != null && !jobFunction.trim().isEmpty())
			result += ", jobFunction: " + jobFunction;
		result += ", salary: " + salary;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}
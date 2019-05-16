package com.niit.NIITPROJECT.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7122553976326435626L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	Integer eId;
	String name;
	
	
	
	public Emp(Integer eId, String name) {
		super();
		this.eId = eId;
		this.name = name;
	}
	public Emp(){}
	
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", name=" + name + "]";
	}
	
	
	  @Override public int hashCode() { final int prime = 31; int result = 1;
	  result = prime * result + ((eId == null) ? 0 : eId.hashCode()); result =
	  prime * result + ((name == null) ? 0 : name.hashCode()); return result; }
	  
	  @Override public boolean equals(Object obj) { if (this == obj) return true;
	  if (obj == null) return false; if (getClass() != obj.getClass()) return
	  false; Emp other = (Emp) obj; if (eId == null) { if (other.eId != null)
	  return false; } else if (!eId.equals(other.eId)) return false; if (name ==
	  null) { if (other.name != null) return false; } else if
	  (!name.equals(other.name)) return false; return true; }
	 

}

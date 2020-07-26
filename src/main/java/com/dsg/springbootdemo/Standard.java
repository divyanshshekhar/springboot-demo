package com.dsg.springbootdemo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.dsg.springbootdemo.Standard.StandardPK;

/**
 * Standard/classes available in school.
 * @author dg185245
 *
 */
@Entity
public class Standard implements Serializable{
	/**
	 * Required for Serializability.
	 */
	private static final long serialVersionUID = -4691762450201603697L;

	@Id
	private StandardPK standardPK;

	
	public Integer getStd() {
		return standardPK.std;
	}
	/*
	public void setStd(Integer std) {
		this.std = std;
	}*/

	public String getSection() {
		return standardPK.section;
	}
	/*
	public void setSection(String section) {
		this.section = section;
	}*/
	
	/**
	 * Primary Key for Standard class.
	 * @author dg185245
	 */
	@Embeddable
	public static class StandardPK implements Serializable{
		protected Integer std;
		protected String section;
		
		public StandardPK() {
			
		}

		public StandardPK(Integer std, String section) {
			super();
			this.std = std;
			this.section = section;
		}

		@Override
		public int hashCode() {
			return Objects.hash(section, std);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			StandardPK other = (StandardPK) obj;
			return Objects.equals(section, other.section) && Objects.equals(std, other.std);
		}
	} 
	
	@Override
	public String toString() {
		return getStd() + " " + getSection();
	}
	
}

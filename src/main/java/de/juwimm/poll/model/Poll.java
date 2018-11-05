package de.juwimm.poll.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(catalog = "test", name = "poll", uniqueConstraints={
	    @UniqueConstraint(columnNames = {"site", "name"})
	})
public class Poll implements Serializable {

	private static final long serialVersionUID = -534062202726536299L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "xmldata")
	@NotNull
	private String xmldata;

	@Column(name = "site")
	@NotNull
	private String site;
	
	@Column(name = "name")
	@NotNull
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getXmldata() {
		return xmldata;
	}

	public void setXmldata(String xmldata) {
		this.xmldata = xmldata;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((xmldata == null) ? 0 : xmldata.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poll other = (Poll) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (xmldata == null) {
			if (other.xmldata != null)
				return false;
		} else if (!xmldata.equals(other.xmldata))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Poll [id=" + id + ", xmldata=" + xmldata + ", site=" + site + ", name=" + name + "]";
	}

}

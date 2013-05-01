package ua.pp.chuprin.web100.cinema.domain.dataset.client;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Layer {
	@Column(name = "`layer_type`")
	@Basic
	private Short type;

	@Column(name = "`layer_isolines`")
	@Basic
	private Boolean isolines;

	public Boolean getIsolines() {
		return isolines;
	}

	public void setIsolines(Boolean isolines) {
		this.isolines = isolines;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
}

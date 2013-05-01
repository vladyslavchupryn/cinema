package ua.pp.chuprin.web100.cinema.domain.dataset.client;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TimeStep {
	@Column(name = "`time_step_in_milli`")
	@Basic
	private Long inMilli;

	@Column(name = "`time_step_type`")
	@Basic
	private Short type;

	public Long getInMilli() {
		return inMilli;
	}

	public void setInMilli(Long inMilli) {
		this.inMilli = inMilli;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
}

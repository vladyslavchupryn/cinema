package ua.pp.chuprin.web100.cinema.domain.dataset.client;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TimeInterval {
	@Column(name = "\"time_interval_start\"")
	@Basic
	private Long start;

	@Column(name = "\"time_interval_end\"")
	@Basic
	private Long end;

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}
}

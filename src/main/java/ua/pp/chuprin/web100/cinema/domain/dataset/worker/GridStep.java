package ua.pp.chuprin.web100.cinema.domain.dataset.worker;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GridStep {
	@Column(name = "grid_step_lat")
	private Float lat;

	@Column(name = "grid_step_lon")
	private Float lon;

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}
}

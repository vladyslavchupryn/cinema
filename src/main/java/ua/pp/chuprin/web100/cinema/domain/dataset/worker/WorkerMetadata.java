package ua.pp.chuprin.web100.cinema.domain.dataset.worker;

import javax.persistence.Embeddable;

@Embeddable
public class WorkerMetadata {

	/**
	 * Маппинг свойств описан в {@link WorkerDataset}
	 */
	private String addOffsetKey;

	private String scaleFactorKey;

	private String missingValueKey;

	private String fillValueKey;

	private Integer addOffset;

	private Integer scaleFactor;

	private Float missingValue;

	public Float getFillValue() {
		return fillValue;
	}

	public void setFillValue(Float fillValue) {
		this.fillValue = fillValue;
	}

	public Float getMissingValue() {
		return missingValue;
	}

	public void setMissingValue(Float missingValue) {
		this.missingValue = missingValue;
	}

	public Integer getScaleFactor() {
		return scaleFactor;
	}

	public void setScaleFactor(Integer scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	public Integer getAddOffset() {
		return addOffset;
	}

	public void setAddOffset(Integer addOffset) {
		this.addOffset = addOffset;
	}

	public String getFillValueKey() {
		return fillValueKey;
	}

	public void setFillValueKey(String fillValueKey) {
		this.fillValueKey = fillValueKey;
	}

	public String getMissingValueKey() {
		return missingValueKey;
	}

	public void setMissingValueKey(String missingValueKey) {
		this.missingValueKey = missingValueKey;
	}

	public String getScaleFactorKey() {
		return scaleFactorKey;
	}

	public void setScaleFactorKey(String scaleFactorKey) {
		this.scaleFactorKey = scaleFactorKey;
	}

	public String getAddOffsetKey() {
		return addOffsetKey;
	}

	public void setAddOffsetKey(String addOffsetKey) {
		this.addOffsetKey = addOffsetKey;
	}

	private Float fillValue;
}

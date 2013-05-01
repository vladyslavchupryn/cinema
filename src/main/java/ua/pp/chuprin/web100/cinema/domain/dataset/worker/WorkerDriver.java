package ua.pp.chuprin.web100.cinema.domain.dataset.worker;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WorkerDriver {

	@Column(name = "driver_type")
	private Short type;

	@Column(name = "driver_bands")
	private Boolean bands;

	@Column(name = "driver_time_step_in_milli")
	private Long timeStepInMilli;

	@Column(name = "driver_pathname_rule_regex")
	private String pathnameRuleRegex;

	@Column(name = "driver_pathname_description_regex")
	private String pathnameDescriptionRegex;

	@Column(name = "driver_pathname_description_string")
	private String pathnameDescriptionString;

	@Column(name = "driver_metadata_prefix")
	private String metadataPrefix;

	@Column(name = "driver_hdf_driver_type")
	private Short hdfDriverType;

	@Column(name = "driver_folder_in_file_with_groups")
	private String folderInFileWithGroups;

	@Column(name = "driver_start_lat_index_offset")
	private Integer startLatIndexOffset;

	@Column(name = "driver_end_lat_index_offset")
	private Integer endLatIndexOffset;

	@Column(name = "driver_start_lat_offset")
	private Float startLatOffset;

	@Column(name = "driver_end_lat_offset")
	private Float endLatOffset;

	@Column(name = "driver_path_in_file")
	private String pathInFile;

	public String getPathInFile() {
		return pathInFile;
	}

	public void setPathInFile(String pathInFile) {
		this.pathInFile = pathInFile;
	}

	public Float getEndLatOffset() {
		return endLatOffset;
	}

	public void setEndLatOffset(Float endLatOffset) {
		this.endLatOffset = endLatOffset;
	}

	public Float getStartLatOffset() {
		return startLatOffset;
	}

	public void setStartLatOffset(Float startLatOffset) {
		this.startLatOffset = startLatOffset;
	}

	public Integer getEndLatIndexOffset() {
		return endLatIndexOffset;
	}

	public void setEndLatIndexOffset(Integer endLatIndexOffset) {
		this.endLatIndexOffset = endLatIndexOffset;
	}

	public Integer getStartLatIndexOffset() {
		return startLatIndexOffset;
	}

	public void setStartLatIndexOffset(Integer startLatIndexOffset) {
		this.startLatIndexOffset = startLatIndexOffset;
	}

	public String getFolderInFileWithGroups() {
		return folderInFileWithGroups;
	}

	public void setFolderInFileWithGroups(String folderInFileWithGroups) {
		this.folderInFileWithGroups = folderInFileWithGroups;
	}

	public Short getHdfDriverType() {
		return hdfDriverType;
	}

	public void setHdfDriverType(Short hdfDriverType) {
		this.hdfDriverType = hdfDriverType;
	}

	public String getMetadataPrefix() {
		return metadataPrefix;
	}

	public void setMetadataPrefix(String metadataPrefix) {
		this.metadataPrefix = metadataPrefix;
	}

	public String getPathnameDescriptionString() {
		return pathnameDescriptionString;
	}

	public void setPathnameDescriptionString(String pathnameDescriptionString) {
		this.pathnameDescriptionString = pathnameDescriptionString;
	}

	public String getPathnameDescriptionRegex() {
		return pathnameDescriptionRegex;
	}

	public void setPathnameDescriptionRegex(String pathnameDescriptionRegex) {
		this.pathnameDescriptionRegex = pathnameDescriptionRegex;
	}

	public String getPathnameRuleRegex() {
		return pathnameRuleRegex;
	}

	public void setPathnameRuleRegex(String pathnameRuleRegex) {
		this.pathnameRuleRegex = pathnameRuleRegex;
	}

	public Long getTimeStepInMilli() {
		return timeStepInMilli;
	}

	public void setTimeStepInMilli(Long timeStepInMilli) {
		this.timeStepInMilli = timeStepInMilli;
	}

	public Boolean getBands() {
		return bands;
	}

	public void setBands(Boolean bands) {
		this.bands = bands;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
}

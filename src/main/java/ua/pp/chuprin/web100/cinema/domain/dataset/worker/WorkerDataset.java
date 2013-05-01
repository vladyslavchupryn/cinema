package ua.pp.chuprin.web100.cinema.domain.dataset.worker;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.ClientDataset;

@Entity
@Table(name = "`WorkerDatasets`")
public class WorkerDataset {

	@OneToOne(mappedBy = "workerDataset")
	private ClientDataset clientDataset;

	@Id
	@GenericGenerator(
		name = "`generator`",
		strategy = "foreign",
		parameters = @Parameter(name = "`property`", value = "clientDataset")
	)
	@GeneratedValue(generator = "generator")
	@Column(name = "`id`")
	private Integer id;

	@Column(name = "`path`")
	private String path;

	@Embedded
	private GridStep gridStep;

	/*
		В данном случае за маппинг отвечает сам класс WorkerDriver

		однако можно использвать @AttributeOverrides (см. ниже)
	 */
	@Embedded
	private WorkerDriver driver;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(
			name = "`addOffsetKey`",
			column = @Column(name = "metadata_add_offset_key")),
		@AttributeOverride(
			name = "`scaleFactorKey`",
			column = @Column(name = "metadata_scale_factor_key")),
		@AttributeOverride(
			name = "`missingValueKey`",
			column = @Column(name = "metadata_missing_value_key")),
		@AttributeOverride(
			name = "`fillValueKey`",
			column = @Column(name = "metadata_fill_value_key")),
		@AttributeOverride(
			name = "`addOffset`",
			column = @Column(name = "metadata_add_offset")),
		@AttributeOverride(
			name = "`scaleFactor`",
			column = @Column(name = "metadata_scale_factor")),
		@AttributeOverride(
			name = "`missingValue`",
			column = @Column(name = "metadata_missing_value")),
		@AttributeOverride(
			name = "`fillValue`",
			column = @Column(name = "metadata_fill_value"))
	})
	private WorkerMetadata metadata;

	@Column(name = "`scan`")
	private String scan;

	@Column(name = "`Name`")
	private String name;

	public GridStep getGridStep() {
		return gridStep;
	}

	public void setGridStep(GridStep gridStep) {
		this.gridStep = gridStep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getScan() {
		return scan;
	}

	public void setScan(String scan) {
		this.scan = scan;
	}

	public ClientDataset getClientDataset() {
		return clientDataset;
	}

	public void setClientDataset(ClientDataset clientDataset) {
		this.clientDataset = clientDataset;
	}

	public WorkerDriver getDriver() {
		return driver;
	}

	public void setDriver(WorkerDriver driver) {
		this.driver = driver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(WorkerMetadata metadata) {
		this.metadata = metadata;
	}
}

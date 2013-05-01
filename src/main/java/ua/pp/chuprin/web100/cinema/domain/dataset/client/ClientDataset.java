package ua.pp.chuprin.web100.cinema.domain.dataset.client;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ua.pp.chuprin.web100.cinema.domain.dataset.worker.WorkerDataset;

@Entity
@Table(name = "\"ClientDatasets\"")
public class ClientDataset {

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private WorkerDataset workerDataset;

	@Id
	@Column(name = "\"id\"")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClientDatasets_id_seq")
	@SequenceGenerator(name = "ClientDatasets_id_seq", sequenceName = "\"ClientDatasets_id_seq\"", allocationSize = 1)
	private Integer id;

	// TODO замапить + lazy load
	@Column(name = "\"Parent\"")
	@Basic
	private Integer parent;

	@Column(name = "\"Name\"")
	@Basic
	private String name;

	@Column(name = "\"description\"")
	@Basic
	private String description;

	@Embedded
	private TimeStep timeStep;

	@Embedded
	private DataProvider dataProvider;

	@Embedded
	private Layer layer;

	@Embedded
	private TimeInterval timeInterval;

	public WorkerDataset getWorkerDataset() {
		return workerDataset;
	}

	public void setWorkerDataset(WorkerDataset workerDataset) {
		this.workerDataset = workerDataset;
		workerDataset.setClientDataset(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TimeStep getTimeStep() {
		return timeStep;
	}

	public void setTimeStep(TimeStep timeStep) {
		this.timeStep = timeStep;
	}

	public DataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(DataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public Layer getLayer() {
		return layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}

	public TimeInterval getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(TimeInterval timeInterval) {
		this.timeInterval = timeInterval;
	}
}

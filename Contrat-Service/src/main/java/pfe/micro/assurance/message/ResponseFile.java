package pfe.micro.assurance.message;

public class ResponseFile {
	
	private Integer contratId;
	private String fileName;
	private String url;
	private String type;
	private long size;
	private boolean etat;
	
	


	public ResponseFile(Integer contratId, String fileName, String url, String type, long size,boolean etat) {
		super();
		this.contratId = contratId;
		this.fileName = fileName;
		this.url = url;
		this.type = type;
		this.size = size;
		this.etat = etat;
	}
	
	
	
	
	public Integer getContratId() {
		return contratId;
	}


	public void setContratId(Integer contratId) {
		this.contratId = contratId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}

	public boolean isEtat() {
		return etat;
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
	}


}

package eira.reportservice.dto;

public class CategoryDTO {

	private String categoryName;
	
	private String ticketTypeName;

	// Corrected constructor with all parameters in the right order
	public CategoryDTO(String categoryName,String ticketTypeName) {
		this.categoryName = categoryName;
	
		this.ticketTypeName = ticketTypeName;
	}

	
	public String getTicketTypeName() {
		return ticketTypeName;
	}


	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}


	


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}

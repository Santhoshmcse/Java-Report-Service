package eira.reportservice.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EnergyServiceDTO {
	private String energyMeterBeforeLogDate;
	private String serviceReportBeforeLogDate;
	private String areaCoveredPictureServerPath;
	private String areaCoveredPictureLogDate;
	private String energyMeterServerPath;
	private String serviceReportServerPath;

	// Internal date format (for storage)
	private static final SimpleDateFormat internalDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// Display date format (for presentation)
	private static final SimpleDateFormat displayDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	// Offset for adding +5.30 hours
	private static final int OFFSET_HOURS = 5;
	private static final int OFFSET_MINUTES = 30;

	public EnergyServiceDTO(String energyMeterServerPath, String serviceReportServerPath,
			String areaCoveredPictureServerPath, String areaCoveredPictureLogDate, String energyMeterBeforeLogDate,
			String serviceReportBeforeLogDate) throws ParseException {
		this.energyMeterServerPath = energyMeterServerPath;
		this.serviceReportServerPath = serviceReportServerPath;
		this.areaCoveredPictureServerPath = areaCoveredPictureServerPath;
		this.areaCoveredPictureLogDate = areaCoveredPictureLogDate;

		setEnergyMeterBeforeLogDate(energyMeterBeforeLogDate); // Apply formatting here
		setServiceReportBeforeLogDate(serviceReportBeforeLogDate); // Apply formatting for service report date
	}

	public String getAreaCoveredPictureServerPath() {
		return areaCoveredPictureServerPath;
	}

	public void setAreaCoveredPictureServerPath(String areaCoveredPictureServerPath) {
		this.areaCoveredPictureServerPath = areaCoveredPictureServerPath;
	}

	public String getAreaCoveredPictureLogDate() {
		return adjustDateWithOffset(areaCoveredPictureLogDate);
	}

	public void setAreaCoveredPictureLogDate(String areaCoveredPictureLogDate) {
		this.areaCoveredPictureLogDate = areaCoveredPictureLogDate;
	}

	public String getEnergyMeterBeforeLogDate() {
		return adjustDateWithOffset(energyMeterBeforeLogDate);
	}

	public void setEnergyMeterBeforeLogDate(String energyMeterBeforeLogDate) throws ParseException {
		if (energyMeterBeforeLogDate != null && !energyMeterBeforeLogDate.isEmpty()) {
			Date parsedDate = internalDateFormat.parse(energyMeterBeforeLogDate);
			this.energyMeterBeforeLogDate = internalDateFormat.format(parsedDate);
		} else {
			this.energyMeterBeforeLogDate = null; // Reset to null if input is null or empty
		}
	}

	public String getServiceReportBeforeLogDate() {
		return adjustDateWithOffset(serviceReportBeforeLogDate);
	}

	public void setServiceReportBeforeLogDate(String serviceReportBeforeLogDate) {
		if (serviceReportBeforeLogDate != null && !serviceReportBeforeLogDate.isEmpty()) {
			this.serviceReportBeforeLogDate = serviceReportBeforeLogDate;
		} else {
			this.serviceReportBeforeLogDate = null;
		}
	}

	public String getEnergyMeterServerPath() {
		return energyMeterServerPath;
	}

	public void setEnergyMeterServerPath(String energyMeterServerPath) {
		this.energyMeterServerPath = energyMeterServerPath;
	}

	public String getServiceReportServerPath() {
		return serviceReportServerPath;
	}

	public void setServiceReportServerPath(String serviceReportServerPath) {
		this.serviceReportServerPath = serviceReportServerPath;
	}

	// Helper method to add +5.30 hours to the date
	private String adjustDateWithOffset(String originalDate) {
		if (originalDate != null) {
			try {
				Date parsedDate = internalDateFormat.parse(originalDate);

				// Use Calendar to add the time offset
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(parsedDate);
				calendar.add(Calendar.HOUR_OF_DAY, OFFSET_HOURS);
				calendar.add(Calendar.MINUTE, OFFSET_MINUTES);

				// Return the adjusted date in display format
				return displayDateFormat.format(calendar.getTime());
			} catch (ParseException e) {
				return null; // Handle parse exception and return null
			}
		}
		return null;
	}
}

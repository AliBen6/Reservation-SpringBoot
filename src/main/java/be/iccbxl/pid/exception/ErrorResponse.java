package be.iccbxl.pid.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ErrorResponse {
	
	public ErrorResponse() {
		
	}

    public ErrorResponse(LocalDateTime timestamp, int status, String message, List<String> details, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.details = details;
		this.path = path;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    // General error message about nature of error
    private int status;

    // General error message about nature of error
    private String message;

    // Specific errors in API request processing
    private List<String> details;

    private String path;
}
package interview.supriya.controller.exception;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ApplicationCriticalException extends WebApplicationException {
	private static final long serialVersionUID = 1L;
	private List<String> errors;
	public ApplicationCriticalException(String... errors) {
	        this(Arrays.asList(errors));
	}
	public ApplicationCriticalException(List<String> errors) {
	        super(Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(new GenericEntity<List<String>>(errors)
	                {}).build());
	        this.errors = errors;
	
	}
	public List<String> getErrors() {
		return errors;
	}
}

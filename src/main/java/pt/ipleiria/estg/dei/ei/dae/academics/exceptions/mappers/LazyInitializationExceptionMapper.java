package pt.ipleiria.estg.dei.ei.dae.academics.exceptions.mappers;

import org.hibernate.LazyInitializationException;
import pt.ipleiria.estg.dei.ei.dae.academics.dtos.ErrorDTO;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LazyInitializationExceptionMapper implements ExceptionMapper<LazyInitializationException> {
    @Override
    public Response toResponse(LazyInitializationException e) {
        var error = new ErrorDTO("We were unable to load the information... . Please, contact our team for support.");
        return Response.serverError().entity(error).build();
    }
}

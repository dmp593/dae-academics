package pt.ipleiria.estg.dei.ei.dae.academics.exceptions.mappers;

import pt.ipleiria.estg.dei.ei.dae.academics.dtos.ErrorDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {
    @Override
    public Response toResponse(EntityNotFoundException e) {
        return getResponse(e);
    }

    protected static Response getResponse(EntityNotFoundException e) {
        var cause = e.getMessage();
        var entity = cause.substring(cause.lastIndexOf('.') + 1, cause.indexOf(" with id"));

        var msg = entity + " not found: " + cause.substring(cause.lastIndexOf(' ') + 1);
        return Response.status(Response.Status.NOT_FOUND).entity(new ErrorDTO(msg)).build();
    }
}

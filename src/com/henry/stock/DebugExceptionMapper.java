package com.henry.stock;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;

public class DebugExceptionMapper implements ExceptionMapper<Throwable> {
	@Override
    public Response toResponse(Throwable e) {
        e.printStackTrace();
        return Response.serverError()
           .entity(e.getMessage())
           .build();
    }
}

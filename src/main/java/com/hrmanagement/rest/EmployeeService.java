package com.hrmanagement.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.hrmanagement.model.Employee;;

@RequestScoped
@Path("/employees")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeService {

	@PersistenceContext(unitName = "hr-management-persistence-unit")
	protected EntityManager entityManager;

	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		Employee employee = (Employee) entityManager.find(Employee.class, id);
		if (employee == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Employee not found for ID: " + id).build();
		}
		return Response.ok(employee, MediaType.APPLICATION_JSON).build();
	}

	/**
	 * @param startPosition
	 * @param maxResult
	 * @return
	 */
	@GET
	public List<Employee> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		return (List<Employee>) query.getResultList();
	}
}

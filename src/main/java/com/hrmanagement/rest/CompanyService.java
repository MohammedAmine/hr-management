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
import com.hrmanagement.model.Company;;

@RequestScoped
@Path("/companies")
@Produces("application/json")
@Consumes("application/json")
public class CompanyService {

	@PersistenceContext(unitName = "hr-management-persistence-unit")
	protected EntityManager entityManager;

	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		Company company = (Company) entityManager.find(Company.class, id);
		if (company == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Company not found for ID: " + id).build();
		}
		return Response.ok(company, MediaType.APPLICATION_JSON).build();
	}

	/**
	 * @param startPosition
	 * @param maxResult
	 * @return
	 */
	@GET
	public List<Company> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		Query query = entityManager.createQuery("SELECT c FROM Company c");
		return (List<Company>) query.getResultList();
	}
}

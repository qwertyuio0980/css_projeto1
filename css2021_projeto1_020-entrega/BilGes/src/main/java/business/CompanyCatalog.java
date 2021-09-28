package business;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import facade.exceptions.ApplicationException;

public class CompanyCatalog {

	/**
	 * Entity manager factory for accessing the persistence service 
	 */
	private EntityManager em;


	/**
	 * Constructs a comapany's catalog giving a entity manager factory
	 */
	public CompanyCatalog(EntityManager em) {
		this.em = em;
	}

	/**
	 * Busca empresa com numero de registo companyNr
	 * @param companyNr numero de registo
	 * @return empresa com numero de registo companyNr
	 * @throws ApplicationException
	 */
	public Company getCompany(int companyNr) throws ApplicationException {
		try {
			TypedQuery<Company> query = em.createNamedQuery(Company.FIND_BY_COMPANYNR, Company.class);
			query.setParameter(Company.COMPANY_NUMBER, companyNr);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}

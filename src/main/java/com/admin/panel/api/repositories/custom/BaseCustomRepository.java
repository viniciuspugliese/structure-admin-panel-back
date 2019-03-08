package com.admin.panel.api.repositories.custom;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public abstract class BaseCustomRepository<T, ID> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Reads the given {@link TypedQuery} into a {@link Page} applying the given
	 * {@link Pageable} and {@link Specification}.
	 *
	 * @param query       must not be {@literal null}.
	 * @param domainClass must not be {@literal null}.
	 * @param spec        can be {@literal null}.
	 * @param pageable    can be {@literal null}.
	 * @return
	 */
	protected <S extends T> Page<S> readPage(TypedQuery<S> query, final Class<S> domainClass, Pageable pageable,
			@Nullable Specification<S> spec) {

		if (pageable.isPaged()) {
			query.setFirstResult((int) pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
		}

		return PageableExecutionUtils.getPage(query.getResultList(), pageable,
				() -> executeCountQuery(getCountQuery(spec, domainClass)));
	}

	/**
	 * Executes a count query and transparently sums up all values returned.
	 *
	 * @param query must not be {@literal null}.
	 * @return
	 */
	private static long executeCountQuery(TypedQuery<Long> query) {

		Assert.notNull(query, "TypedQuery must not be null!");

		List<Long> totals = query.getResultList();
		long total = 0L;

		for (Long element : totals) {
			total += element == null ? 0 : element;
		}

		return total;
	}

	/**
	 * Creates a new count query for the given {@link Specification}.
	 *
	 * @param spec        can be {@literal null}.
	 * @param domainClass must not be {@literal null}.
	 * @return
	 */
	protected <S extends T> TypedQuery<Long> getCountQuery(@Nullable Specification<S> spec, Class<S> domainClass) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);

		Root<S> root = applySpecificationToCriteria(spec, domainClass, query);

		if (query.isDistinct()) {
			query.select(builder.countDistinct(root));
		} else {
			query.select(builder.count(root));
		}

		// Remove all Orders the Specifications might have applied
		query.orderBy(Collections.<Order>emptyList());

		return entityManager.createQuery(query);
	}

	/**
	 * Applies the given {@link Specification} to the given {@link CriteriaQuery}.
	 *
	 * @param spec        can be {@literal null}.
	 * @param domainClass must not be {@literal null}.
	 * @param query       must not be {@literal null}.
	 * @return
	 */
	private <S, U extends T> Root<U> applySpecificationToCriteria(@Nullable Specification<U> spec, Class<U> domainClass,
			CriteriaQuery<S> query) {

		Assert.notNull(domainClass, "Domain class must not be null!");
		Assert.notNull(query, "CriteriaQuery must not be null!");

		Root<U> root = query.from(domainClass);

		if (spec == null) {
			return root;
		}

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		Predicate predicate = spec.toPredicate(root, query, builder);

		if (predicate != null) {
			query.where(predicate);
		}

		return root;
	}
}

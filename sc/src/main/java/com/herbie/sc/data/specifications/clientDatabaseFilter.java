package com.herbie.sc.data.specifications;

import com.herbie.sc.data.models.Client;

import javax.persistence.criteria.*;
import java.util.ArrayList;

public class ClientDatabaseFilter implements org.springframework.data.jpa.domain.Specification<Client> {

    String userQuery;

    public ClientDatabaseFilter(String queryString) {
        this.userQuery = queryString;
    }

    @Override
    public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)  {
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (userQuery != null && userQuery != "") {
            predicates.add(criteriaBuilder.like(root.get("employee"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("emailAddress"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("city"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("country"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("phoneNumber"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("spokeToDc"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("dcPartner"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("relationshipStrength"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("companyName"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("contactMethod"), '%' + userQuery + '%'));
        }

        return (! predicates.isEmpty() ? criteriaBuilder.or(predicates.toArray(new javax.persistence.criteria.Predicate[predicates.size()])) : null);
    }
}

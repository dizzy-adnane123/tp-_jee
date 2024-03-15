package org.telmoudy.hospital.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.telmoudy.hospital.entities.Patient;

public class PatientSpecifications {
    public static Specification<Patient> scoreBetween(double min, double max) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("score"), min, max);
    }
}

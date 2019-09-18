package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> findDistilleryThatHaveWhiskyAged(int age) {
        List<Distillery> results = null;

        try {
            Session session = entityManager.unwrap(Session.class);
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whiskiesAlias");
            cr.add(Restrictions.eq("whiskiesAlias.age", age));
            results = cr.list();
        }

        catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return results;

    }
}

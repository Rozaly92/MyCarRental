package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.GearBox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GearBoxDAOImpl implements GearBoxDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<GearBox> getAllGearBoxes() {
        Session session = entityManager.unwrap(Session.class);
        List<GearBox> allGearBoxes = session.createQuery("from GearBox", GearBox.class)
                .getResultList();
        return allGearBoxes;
    }
    @Override
    public void saveGearBox(GearBox gearBox) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(gearBox);
    }
}

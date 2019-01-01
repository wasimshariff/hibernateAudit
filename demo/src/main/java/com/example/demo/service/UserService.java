package com.example.demo.service;


import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.order.AuditOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private EntityManagerFactory factory;

    public void addUsers(UserEntity vo) {
        usersRepository.save(vo);
    }

    public void updateUser(UserEntity vo) {
        usersRepository.save(vo);
    }

    public List<UserEntity> listUsers() {
        List<UserEntity> users = new ArrayList<>();
        try {
            AuditReader audit = AuditReaderFactory.get(factory.createEntityManager());
            List<UserEntity> userEntities = audit.createQuery()
                    .forRevisionsOfEntity(UserEntity.class, true, true)
                    .add(AuditEntity.id().eq(3L)) // UserId
                    .addOrder(AuditEntity.revisionNumber().desc())
                    .setMaxResults(5)
                    .getResultList();
            System.out.println(userEntities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        usersRepository.findAll().forEach(users::add);
        return users;
    }



}

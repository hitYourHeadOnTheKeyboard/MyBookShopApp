package com.example.MyBookShopApp.config;

import com.example.MyBookShopApp.data.TestEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.logging.Logger;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    EntityManagerFactory entityManagerFactory;

    @Autowired
    public CommandLineRunnerImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 5; i++) {
            createTestEntity(new TestEntity());
        }

        TestEntity readTestEntity = readTestEntityById(3L);
        if (readTestEntity != null) {
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read" + readTestEntity);
        }else {
            throw new NullPointerException();
        }

        TestEntity updatedTestEntity = updateTestEntity(5L);
        if (updatedTestEntity != null) {
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update" + updatedTestEntity);
        }else {
            throw new NullPointerException();
        }

        deleteTestEntityById(4L);

    }

    private void createTestEntity(TestEntity entity) {
        Transaction ts = null;
        try (Session session = entityManagerFactory.createEntityManager().unwrap(Session.class)) {
            ts = session.beginTransaction();
            entity.setData(entity.getClass().getSimpleName() + entity.hashCode());
            session.save(entity);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            } else {
                e.printStackTrace();
            }
        }
    }

    private TestEntity readTestEntityById(Long id) {
        Transaction ts = null;
        TestEntity entity = null;

        try (Session session = entityManagerFactory.createEntityManager().unwrap(Session.class)) {
            ts = session.beginTransaction();
            entity = session.find(TestEntity.class, id);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            } else {
                e.printStackTrace();
            }
        }

        return entity;
    }

    private TestEntity updateTestEntity(Long id) {
        Transaction ts = null;
        TestEntity entity = null;

        try (Session session = entityManagerFactory.createEntityManager().unwrap(Session.class)) {
            ts = session.beginTransaction();
            TestEntity findEntity = readTestEntityById(id);
            findEntity.setData("NEW DATA INSERTED");
            entity = (TestEntity) session.merge(findEntity);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            } else {
                e.printStackTrace();
            }
        }
        return entity;
    }

    private void deleteTestEntityById(Long id) {
        Transaction ts = null;

        try (Session session = entityManagerFactory.createEntityManager().unwrap(Session.class)) {
            ts = session.beginTransaction();
            TestEntity findEntity = readTestEntityById(id);
            TestEntity mergedTestEntity = (TestEntity) session.merge(findEntity);
            session.remove(mergedTestEntity);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            } else {
                e.printStackTrace();
            }
        }
    }
}

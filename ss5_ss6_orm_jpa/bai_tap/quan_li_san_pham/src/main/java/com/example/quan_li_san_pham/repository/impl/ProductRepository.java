package com.example.quan_li_san_pham.repository.impl;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.repository.ConnectionUtils;
import com.example.quan_li_san_pham.repository.IProductRepository;
import com.example.quan_li_san_pham.service.IProductService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
//    private static List<Product> productList = new ArrayList<>();
//
//    static {
//        productList.add(new Product(1, "bút bi", "học tâp", "thien long", 5000));
//        productList.add(new Product(2, "bút mực", "học tâp", "thien long", 8000));
//        productList.add(new Product(3, "bút chì", "học tâp", "thien long", 3000));
//    }

    private static final String SELECT_ALL_PRODUCTS = "from Product";

    @Override
    public List<Product> findAll() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCTS).getResultList();
    }

    @Override
    public void create(Product product) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            session.save(product);
            transactional.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = ConnectionUtils.getEntityManager().
                createQuery("select p from Product p where  p.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(product);
            transaction.commit();
            ConnectionUtils.getEntityManager().clear();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
//            ConnectionUtils.getEntityManager().clear();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }


    @Override
    public List<Product> findSearch(String search) {
        if (search == null) {
            search = "";
        }
        TypedQuery<Product> query = ConnectionUtils.getEntityManager().
                createQuery("select p from Product p where  p.name like concat('%',:search,'%')", Product.class);
        query.setParameter("search", search);
        return query.getResultList();
    }
}

package br.com.threeway.locadora.dao;

import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FilmeDao {


	public Filme pegueFilme(Long id){
		EntityManager em = null;
		try{
			em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			return em.find(Filme.class,id);
		}
		finally {
			if(em != null){
				em.close();
			}
		}

	}


	public List<Filme> listeFilmes(){
		EntityManager em = null;
		try{
			em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			TypedQuery<Filme> query = em.createQuery(
					"FROM Filme",Filme.class);

			return query.getResultList();
		}
		finally {
			if(em != null){
				em.close();
			}
		}
	}


	public void insira(Filme filme){
		EntityManager em = null;
		try{
			em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(filme);
			em.getTransaction().commit();
		}catch (Exception e){
			em.getTransaction().rollback();
		}
		finally {
			if(em != null){
				em.close();
			}
		}
	}

	public void atualize(Filme filme){
		EntityManager em = null;
		try{
			em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(filme);
			em.getTransaction().commit();
		}catch (Exception e){
			em.getTransaction().rollback();
		}
		finally {
			if(em != null){
				em.close();
			}
		}
	}

	public void delete(Filme filme){
		EntityManager em = null;
		try{
			em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(filme));
			em.getTransaction().commit();
		}catch (Exception e){
			em.getTransaction().rollback();
		}
		finally {
			if(em != null){
				em.close();
			}
		}
	}

	public List<Filme> busqueFilmes(String busca){
		EntityManager em = null;
		try{
			em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			TypedQuery<Filme> query = em.createQuery(
					"FROM Filme f where f.nome like :busca",Filme.class);

			query.setParameter("busca","%"+busca+"%");
			return query.getResultList();
		}
		finally {
			if(em != null){
				em.close();
			}
		}
	}
}
